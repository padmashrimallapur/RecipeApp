package com.example.recipeapp.presentation.ui.recipelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.recipeapp.presentation.ui.compose.RecipeCard
import dagger.hilt.android.AndroidEntryPoint

@kotlinx.coroutines.ExperimentalCoroutinesApi
@AndroidEntryPoint
class RecipeFragmentList : Fragment() {

    val viewModel: RecipeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply {
            setContent {
                val recipes = viewModel.recipes.value
                LazyColumn {
                    itemsIndexed(items = recipes) { index, recipe ->
                        RecipeCard(recipe = recipe, onClick = {})
                    }
                }
            }
        }
    }
}