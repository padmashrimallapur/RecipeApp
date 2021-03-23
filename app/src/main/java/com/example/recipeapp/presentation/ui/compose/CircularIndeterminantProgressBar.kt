package com.example.recipeapp.presentation.ui.compose

import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.ConstraintSet
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.WithConstraints
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.withContext

@Composable
fun circularIndeterminantCircularBar(
    isDisplayed: Boolean,
) {
    if (isDisplayed) {

        WithConstraints(modifier = Modifier.fillMaxSize()) {
            val constraints = if (minWidth < 600.dp) {
                myDecoupledConstraints(0.7f)
            } else {
                myDecoupledConstraints(0.3f)
            }


            ConstraintLayout(
                modifier = Modifier.fillMaxSize() ,
                constraintSet = constraints

            ) {
                CircularProgressIndicator(
                    modifier = Modifier.layoutId("progressBar"),
                    color = MaterialTheme.colors.primary,
                    )
                Text(text = "Loading",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = TextUnit.Companion.Sp(12)
                    ),
                    modifier = Modifier.layoutId("text")

                )
            }
        }
    }
}

private fun myDecoupledConstraints(varticalBias: Float) : ConstraintSet{
    return ConstraintSet {

        val topGuideline = createGuidelineFromTop(0.3f)
        val progressBar = createRefFor("progressBar")
        val text = createRefFor("text")

        constrain(progressBar){
            top.linkTo(topGuideline)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(text){
            top.linkTo(progressBar.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

    }
}
