package com.example.recipeapp.network.model.retrofit

import com.example.recipeapp.network.model.RecipeDto
import com.example.recipeapp.network.model.response.RecipeSearchResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RecipeService {

    @GET("search")
    suspend fun search(
        @Header("Authorization") token : String,
        @Query("page") page : Int,
        @Query("query") query: String

    ):RecipeSearchResponse

    //Get recipe by Id
    @GET("get")
    suspend fun get(
        @Header("Authorization") token : String,
        @Query("id") id : Int
    ):RecipeDto
}