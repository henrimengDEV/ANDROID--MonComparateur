package com.example.my_first_app.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class NutritionFacts(
    val calories: NutritionFactsItem? = null,
    val fat: NutritionFactsItem? = null,
    val saturatedFat: NutritionFactsItem? = null,
    val glucide: NutritionFactsItem? = null,
    val sugar: NutritionFactsItem? = null,
    val fibre: NutritionFactsItem? = null,
    val prot: NutritionFactsItem? = null,
    val salt: NutritionFactsItem? = null,
    val sodium: NutritionFactsItem? = null,
) : Parcelable