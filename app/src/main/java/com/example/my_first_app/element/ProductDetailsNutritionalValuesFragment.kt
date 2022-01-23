package com.example.my_first_app.element

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.my_first_app.R
import com.example.my_first_app.model.NutritionFactsItem
import com.example.my_first_app.model.Product

class ProductDetailsNutritionalValuesFragment : Fragment() {

    private var product: Product? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.product_details_nutritional_values, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val detailsFragment: ProductDetailsFragment = requireParentFragment().requireParentFragment() as ProductDetailsFragment
        this.product = ProductDetailsFragmentArgs.fromBundle(detailsFragment.requireArguments()).product
        this.updateNutrionFactRow(view, R.id.product_energies_100g, R.id.product_energies_portion, this.product?.nutrientLevels?.calories)
        this.updateNutrionFactRow(view, R.id.product_fat_100g, R.id.product_fat_portion, this.product?.nutrientLevels?.fat)
        this.updateNutrionFactRow(view, R.id.product_satured_fat_100g, R.id.product_satured_fat_portion, this.product?.nutrientLevels?.saturatedFat)
        this.updateNutrionFactRow(view, R.id.product_glucides_100g, R.id.product_glucides_portion, this.product?.nutrientLevels?.glucide)
        this.updateNutrionFactRow(view, R.id.product_sugar_100g, R.id.product_sugar_portion, this.product?.nutrientLevels?.sugar)
        this.updateNutrionFactRow(view, R.id.product_fibre_100g, R.id.product_fibre_portion, this.product?.nutrientLevels?.fibre)
        this.updateNutrionFactRow(view, R.id.product_prot_100g, R.id.product_prot_portion, this.product?.nutrientLevels?.prot)
        this.updateNutrionFactRow(view, R.id.product_salt_100g, R.id.product_salt_portion, this.product?.nutrientLevels?.salt)
        this.updateNutrionFactRow(view, R.id.product_sodium_100g, R.id.product_sodium_portion, this.product?.nutrientLevels?.sodium)
    }

    fun updateNutrionFactRow(view: View, idPerGram: Int, idPerPortion: Int, nutrionFact: NutritionFactsItem? = null) {
        if (nutrionFact === null) return;

        if (nutrionFact.quantityPer100g != 0) view.findViewById<TableCellView>(idPerGram).text = "${nutrionFact.quantityPer100g.toString()} ${nutrionFact.unit}"
        else view.findViewById<TableCellView>(idPerGram).text = "?"

        if (nutrionFact.quantityPerPortion != 0) view.findViewById<TableCellView>(idPerPortion).text = "${nutrionFact.quantityPerPortion.toString()} ${nutrionFact.unit}"
        else view.findViewById<TableCellView>(idPerPortion).text = "?"
    }

}