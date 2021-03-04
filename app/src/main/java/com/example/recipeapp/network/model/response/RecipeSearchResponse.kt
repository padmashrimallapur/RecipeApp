package com.example.recipeapp.network.model.response

import com.example.recipeapp.network.model.RecipeDto
import com.google.gson.annotations.SerializedName

data class RecipeSearchResponse  (
    @SerializedName("count" )
    var count : Int,

    @SerializedName("results")
    var recipies : List<RecipeDto>
    )