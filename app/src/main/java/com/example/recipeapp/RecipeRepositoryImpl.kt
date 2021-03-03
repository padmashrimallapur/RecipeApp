package com.example.recipeapp

import com.example.recipeapp.domain.Recipe
import com.example.recipeapp.network.model.RecipeDto
import com.example.recipeapp.network.model.RecipeDtoMapper
import com.example.recipeapp.network.model.retrofit.RecipeService

class RecipeRepositoryImpl(
    private val recipeService:RecipeService,
    private val mapper : RecipeDtoMapper
) : RecipeRepository{

    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(recipeService.search(token = token, page = page, query = query).recipies)
    }

    override suspend fun get(token: String, id: Int): Recipe {
       return mapper.mapToDomainModel(recipeService.get(token = token, id = id))
    }
}