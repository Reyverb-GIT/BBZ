package com.example.baguiobluezone.foodhub.recipe.data.model


import com.google.gson.annotations.SerializedName

data class MealResponse(
    @SerializedName("meals")
    val meals: List<Meal>
)