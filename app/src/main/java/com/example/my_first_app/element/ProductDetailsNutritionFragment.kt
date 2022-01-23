package com.example.my_first_app.element

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import com.example.my_first_app.R
import com.example.my_first_app.model.NutritionFactsItem
import com.example.my_first_app.model.Product

class ProductDetailsNutritionFragment : Fragment() {

    private var product: Product? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.product_details_nutrition, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val detailsFragment: ProductDetailsFragment =
            requireParentFragment().requireParentFragment() as ProductDetailsFragment
        this.product =
            ProductDetailsFragmentArgs.fromBundle(detailsFragment.requireArguments()).product

        this.updateDataRow(
            view,
            R.id.product_details_nutrition_fat_level,
            R.id.product_details_nutrition_fat,
            product?.nutrientLevels?.fat,
            "de matières grasses / lipides"
        )
        this.updateDataRow(
            view,
            R.id.product_details_nutrition_satured_fat_level,
            R.id.product_details_nutrition_satured_fat,
            product?.nutrientLevels?.saturatedFat,
            "d'acide gras saturés"
        )
        this.updateDataRow(
            view,
            R.id.product_details_nutrition_sugar_level,
            R.id.product_details_nutrition_sugar,
            product?.nutrientLevels?.sugar,
            "de sucres"
        )
        this.updateDataRow(
            view,
            R.id.product_details_nutrition_salt_level,
            R.id.product_details_nutrition_salt,
            product?.nutrientLevels?.salt,
            "de sel"
        )
    }

    fun updateDataRow(
        view: View,
        idLevel: Int,
        idDescription: Int,
        nutritionFactItem: NutritionFactsItem? = null,
        textDescription: String
    ) {
        val fatLevel: View = view.findViewById(idLevel)
        val fatDescription: TextView = view.findViewById(idDescription)

        if (nutritionFactItem === null) {
            fatDescription.setText("?? ${textDescription}")
            return
        }

        DrawableCompat.setTintList(
            fatLevel.background,
            ColorStateList.valueOf(resources.getColor(findCorrectColorLevel(nutritionFactItem.quantityPer100g)))
        )

        fatDescription.setText("${nutritionFactItem?.quantityPer100g}${nutritionFactItem?.unit} ${textDescription}")
    }

    private fun findCorrectColorLevel(number: Number? = null): Int {
        if (number === null || number.toDouble() < 1) return R.color.nutrient_level_low
        else if (1 < number.toDouble() && number.toDouble() < 2) return R.color.nutrient_level_moderate
        else return R.color.nutrient_level_high
    }

}