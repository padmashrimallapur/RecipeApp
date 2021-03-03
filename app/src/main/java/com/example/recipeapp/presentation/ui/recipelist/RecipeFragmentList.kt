package com.example.recipeapp.presentation.ui.recipelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.recipeapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeFragmentList : Fragment() {

    val viewModel: RecipeListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("RecipeFragmentList : ${viewModel.getRandome()}")
        println("RecipeFragmentList : ${viewModel.getRepository()}")
        println("RecipeFragmentList : ${viewModel.getToken()}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Column(
                    modifier = Modifier
                        .border(
                            border = BorderStroke(1.dp, Color.Black)
                        )
                        .padding(16.dp)
                ) {
                    Text(text = "Recipe List")
                    Spacer(modifier = Modifier.padding(top = 10.dp))
                    Button(onClick = { findNavController().navigate(R.id.viewRecipe) }) {
                        Text(text = "To Recipe Fragment")
                    }
                }
            }
        }
    }
}