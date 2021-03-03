package com.example.recipeapp.presentation.ui.recipelist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

class RecipeListViewModel
    @ViewModelInject
    constructor(
            private val randomString: String
    ) : ViewModel(){

        init {
            print("ViewModel ${randomString}")
        }

}