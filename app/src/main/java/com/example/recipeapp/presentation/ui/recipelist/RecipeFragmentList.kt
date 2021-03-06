package com.example.recipeapp.presentation.ui.recipelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
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
                Surface(

                    elevation = 8.dp
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {

                        Column {
                            val query = viewModel.query.value
                            TextField(
                                modifier = Modifier
                                    .fillMaxWidth(0.9f)
                                    .padding(8.dp),
                                value = query,
                                onValueChange = { viewModel.onQueryChanged(newValue = it) },
                                label = {
                                    Text(text = "Search")
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text,
                                    imeAction = ImeAction.Done,

                                    ),
                                leadingIcon = { Icon(Icons.Filled.Search) },
                                onImeActionPerformed = { action, softKeyboardController ->
                                    if (action == ImeAction.Done) {
                                        viewModel.newSearch(query)
                                        softKeyboardController?.hideSoftwareKeyboard()
                                    }
                                },
                                textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
                                backgroundColor = MaterialTheme.colors.surface
                            )

                            Spacer(modifier = Modifier.padding(top = 10.dp))

                            LazyColumn {
                                itemsIndexed(items = recipes) { index, recipe ->
                                    RecipeCard(recipe = recipe, onClick = {})
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}