package com.example.recipeapp.presentation.ui.recipelist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.recipeapp.repository.RecipeRepository
import javax.inject.Named

class RecipeListViewModel
    @ViewModelInject
    constructor(
            private val randomString: String,
            private val repository: RecipeRepository,
            private  @Named("auth_token") val token : String
    ) : ViewModel(){

    init {
        println("RecipeListViewModel ${randomString}")
        println("RecipeListViewModel ${repository}")
        println("RecipeListViewModel ${token}")
    }

    fun getRandome() = randomString
    fun getRepository() = repository
    fun getToken() = token

}