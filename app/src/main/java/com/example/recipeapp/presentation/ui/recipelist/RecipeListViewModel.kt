package com.example.recipeapp.presentation.ui.recipelist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.domain.Recipe
import com.example.recipeapp.repository.RecipeRepository
import kotlinx.coroutines.launch
import javax.inject.Named

class RecipeListViewModel
    @ViewModelInject
    constructor(

            private val repository: RecipeRepository,
            private  @Named("auth_token") val token : String,
    ) : ViewModel() {

    val recipes: MutableState<List<Recipe>> = mutableStateOf(ArrayList())


    fun newSearch(){
        viewModelScope.launch {
            val result = repository.search(
                token = token,
                page = 1,
                query = "chicken"
            )
            recipes.value = result
        }
    }
}