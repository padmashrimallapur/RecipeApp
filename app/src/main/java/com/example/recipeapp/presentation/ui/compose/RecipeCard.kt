package com.example.recipeapp.presentation.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.recipeapp.domain.Recipe
import com.example.recipeapp.util.DEFAULT_RECIPE_IMAGE
import com.example.recipeapp.util.loadPitcure
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@Composable
fun RecipeCard(
    recipe: Recipe,
    onClick: () -> Unit,
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp,
            )
            .fillMaxWidth(),
        elevation = 8.dp,
    ) {
        Column {
            recipe.featuredImage?.let { url ->
                val image = loadPitcure(url = url, defaultImage = DEFAULT_RECIPE_IMAGE).value
                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .preferredHeight(225.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            recipe.title?.let { title ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                ) {
                    Text(
                        text = title,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.h5
                    )
                    Text(
                        text = recipe.rating.toString(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                            .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.h6
                    )
                }
            }
        }
    }
}