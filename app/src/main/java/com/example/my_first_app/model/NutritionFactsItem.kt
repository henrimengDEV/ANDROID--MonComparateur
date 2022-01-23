package com.example.my_first_app.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class NutritionFactsItem(
    val unit: String? = "",
    val quantityPerPortion: Number? = 0,
    val quantityPer100g: Number? = 0
) : Parcelable