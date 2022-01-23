package com.example.my_first_app.element

import android.graphics.Typeface
import android.icu.number.NumberFormatter.with
import android.os.Bundle
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.my_first_app.R
import com.example.my_first_app.model.Product
import com.squareup.picasso.Picasso

class ProductDetailsSummaryFragment : Fragment() {

    private var product: Product? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.product_details_summary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val detailsFragment: ProductDetailsFragment =
            requireParentFragment().requireParentFragment() as ProductDetailsFragment
        this.product =
            ProductDetailsFragmentArgs.fromBundle(detailsFragment.requireArguments()).product
        this.product?.initProductDetailView(view)
        this.findCorrectNutriImg(
            view.findViewById(R.id.product_details_nutriscore_img),
            this.product?.score
        )
    }

    private fun Product.initProductDetailView(view: View) {
        view.findViewById<TextView>(R.id.product_details_name).text = this.name
        view.findViewById<TextView>(R.id.product_details_brand).text = this.brand
        view.findViewById<TextView>(R.id.product_details_barcode).setBoldValue(
            getString(
                R.string.product_barcode,
                this.barcode
            )
        )
        view.findViewById<TextView>(R.id.product_details_quantity).setBoldValue(
            getString(
                R.string.product_quantity,
                this?.quantity
            )
        )
        view.findViewById<TextView>(R.id.product_details_seller_countries).setBoldValue(
            getString(
                R.string.product_seller_countries,
                this?.sellerCountries?.joinToString()
            )
        )
        view.findViewById<TextView>(R.id.product_details_ingredients).setBoldValue(
            getString(
                R.string.product_ingredients,
                this?.ingredients?.joinToString()
            )
        )
        view.findViewById<TextView>(R.id.product_details_allergies).setBoldValue(
            getString(
                R.string.product_allergies,
                this?.allergies?.joinToString()
            )
        )
        view.findViewById<TextView>(R.id.product_details_additives).setBoldValue(
            getString(
                R.string.product_additives,
                this?.additives?.joinToString()
            )
        )

        Picasso.get().load(product?.urlImg).fit().centerCrop()
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(view.findViewById<ImageView>(R.id.product_details_img))
    }

    private fun TextView.setBoldValue(value: String) {
        val index = value.indexOf(':')
        val spannable = SpannableString(value)

        spannable.setSpan(StyleSpan(Typeface.BOLD), 0, index, 0)
        setText(spannable)
    }

    private fun findCorrectNutriImg(img: ImageView, score: String? = null) {
        if (score == null || score == "A") {
            img.setImageResource(R.drawable.nutriscore_a)
        } else if (score == "B") {
            img.setImageResource(R.drawable.nutriscore_b)
        } else if (score == "C") {
            img.setImageResource(R.drawable.nutriscore_c)
        } else if (score == "D") {
            img.setImageResource(R.drawable.nutriscore_d)
        } else if (score == "E") {
            img.setImageResource(R.drawable.nutriscore_e)
        }
    }
}