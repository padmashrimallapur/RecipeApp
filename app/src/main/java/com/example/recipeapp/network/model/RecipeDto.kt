package com.example.recipeapp.network.model

import com.google.gson.annotations.SerializedName

class RecipeDto (

    @SerializedName("pk")
    var pk:Int? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("featuredImage")
    var featuredImage: String? = null,

    @SerializedName("publisher")
    var publisher: String? = null,

    @SerializedName("rating")
    var rating: Int? = 0,

    @SerializedName("source_url")
    var source_url: String? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("cooking_instructions")
    var cooking_instructions: String? = null,

    @SerializedName("ingredients")
    var ingredients: List<String>? = null,

    @SerializedName("date_added")
    var date_added: String? = null,

    @SerializedName("date_updated")
    var date_updated: String? = null,
)