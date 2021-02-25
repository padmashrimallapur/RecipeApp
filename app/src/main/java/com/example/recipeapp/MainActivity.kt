package com.example.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setContent {
            ScrollableColumn(modifier =
                Modifier.fillMaxSize()
                .background(color = Color(0xFFEEECEC))
            )
            {
                Image(bitmap = imageFromResource(res = resources, resId = R.drawable.happy_meal_small),
                    modifier = Modifier.height(300.dp),
                    contentScale = ContentScale.Crop,
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Happy Meal",
                        style = TextStyle(
                            fontSize = TextUnit.Companion.Sp(26)
                        )
                    )
                    Spacer(modifier = Modifier.padding(top= 10.dp))
                    Text(text = "800 Calories",
                        style = TextStyle(
                            fontSize = TextUnit.Companion.Sp(17)
                        )
                    )
                    Spacer(modifier = Modifier.padding(top = 10.dp))
                    Text(text = "$5.99",
                        style = TextStyle(
                            fontSize = TextUnit.Companion.Sp(18),
                            color = Color(0xFF85B453)
                        )
                    )
                }

            }

        }
    }
}