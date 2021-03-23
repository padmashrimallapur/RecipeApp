package com.example.recipeapp.presentation.ui.recipelist


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.recipeapp.BaseApplication
import com.example.recipeapp.presentation.ui.compose.RecipeCard
import com.example.recipeapp.presentation.ui.compose.SearchAppBar
import com.example.recipeapp.presentation.ui.compose.circularIndeterminantCircularBar
import com.example.recipeapp.presentation.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@kotlinx.coroutines.ExperimentalCoroutinesApi
@AndroidEntryPoint
class RecipeFragmentList : Fragment() {

    @Inject
    lateinit var application: BaseApplication

    val viewModel: RecipeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply {
            setContent {

                AppTheme(darkTheme = application.isDarkTheme.value) {

                    Column(
                        modifier = Modifier.background(color = MaterialTheme.colors.surface)
                    ) {
                        val recipes = viewModel.recipes.value
                        val selectedCategory = viewModel.selectedCategory.value
                        val query = viewModel.query.value
                        val categoryScrollPosition = viewModel.categoryScrollPosition
                        val loading = viewModel.loading.value

                        SearchAppBar(
                            query = query,
                            onQueryChanged = viewModel::onQueryChanged,
                            onExecuteSearch = viewModel::newSearch,
                            scrollPosition = categoryScrollPosition,
                            selectedCategory = selectedCategory,
                            onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,
                            onChangeCategoryScrollPosition = viewModel::onChangeCategoryScrollPosition,
                            onToggleTheme = { application.toggleLightTheme() }
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
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
}


