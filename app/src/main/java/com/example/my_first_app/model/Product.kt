package com.example.my_first_app.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Product(
    val additives: List<String>? = listOf(),
    val allergies: List<String>? = listOf(),
    val barcode: String? = "",
    val brand: String? = "",
    val score: String? = "",
    val ingredients: List<String>? = listOf(),
    val quantity: String? = "",
    val name: String? = "",
    val nutrientLevels: NutritionFacts? = null,
    val sellerCountries: List<String>? = listOf(),
    val urlImg: String? = "",
) : Parcelable {

    override fun toString(): String {
        return "Product(additives=$additives, allergies=$allergies, barcode=$barcode, brand=$brand, score=$score, ingredients=$ingredients, quantity=$quantity, name=$name, nutrientLevels=$nutrientLevels, sellerCountries=$sellerCountries, urlImg=$urlImg)"
    }
}