package com.example.recipeapp.presentation.ui.recipelist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.input.key.Key.Companion.Sleep
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.domain.Recipe
import com.example.recipeapp.repository.RecipeRepository
import kotlinx.coroutines.launch
import java.lang.Thread.sleep
import javax.inject.Named

class RecipeListViewModel
@ViewModelInject
constructor(

    private val repository: RecipeRepository,
    @Named("auth_token") private val token: String,
) : ViewModel() {

    val recipes: MutableState<List<Recipe>> = mutableStateOf(ArrayList())
    val query = mutableStateOf("")

    val selectedCategory: MutableState<FoodCategory?> = mutableStateOf(null)
    var categoryScrollPosition: Float = 0f
    var loading = mutableStateOf(false)

    init {
        newSearch()
    }

    fun newSearch() {
        viewModelScope.launch {
            loading.value = true
            resetSearchCategory()
            val result = repository.search(
                token = token,
                page = 1,
                query = query.value
            )

            recipes.value = result
            loading.value = false
        }
    }

    fun onQueryChanged(newValue: String) {
        this.query.value = newValue
    }

    fun onSelectedCategoryChanged(category: String) {
        val newCategory = getFoodCategory(category)
        selectedCategory.value = newCategory
        onQueryChanged(category)
    }

    fun onChangeCategoryScrollPosition(scrollPosition: Float) {
        categoryScrollPosition = scrollPosition
    }
    fun clearSelectedCategory(){
        selectedCategory.value = null
    }

    fun resetSearchCategory(){
        recipes.value = listOf()
        if(selectedCategory.value?.value != query.value){
            clearSelectedCategory()
        }
    }
}