package com.example.recipeapp.presentation.ui.recipelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.recipeapp.presentation.ui.compose.RecipeCard
import com.example.recipeapp.presentation.ui.compose.SearchAppBar
import com.example.recipeapp.presentation.ui.compose.circularIndeterminantCircularBar
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
                Column {
                    val recipes = viewModel.recipes.value
                    val selectedCategory = viewModel.selectedCategory.value
                    val query = viewModel.query.value
                    val categoryScrollPosition = viewModel.categoryScrollPosition
                    val loading = viewModel.loading.value
                    SearchAppBar(
                        query = query,
                        onQueryChanged = viewModel::onQueryChanged,
                        onExecuteSearch = viewModel::newSearch,
                        scrollPosition = categoryScrollPosition ,
                        selectedCategory = selectedCategory ,
                        onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,
                        onChangeCategoryScrollPosition = viewModel :: onChangeCategoryScrollPosition)
                    Box(modifier = Modifier.fillMaxWidth()
                        .fillMaxHeight()
                    ) {

                        LazyColumn {
                            itemsIndexed(items = recipes) { index, recipe ->
                                RecipeCard(recipe = recipe, onClick = {})
                            }
                        }
                        circularIndeterminantCircularBar(loading)
                    }
                }
            }
        }
    }
}