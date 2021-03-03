package com.example.recipeapp.repository

import com.example.recipeapp.domain.Recipe

interface RecipeRepository {

    suspend fun search(token: String, page: Int, query:String) : List<Recipe>

    suspend fun get(token: String, id: Int) : Recipe
}