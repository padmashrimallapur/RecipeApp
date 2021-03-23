package com.example.recipeapp.presentation.ui.compose

import android.annotation.SuppressLint

import androidx.compose.animation.ColorPropKey
import androidx.compose.animation.DpPropKey
import androidx.compose.animation.core.*
import androidx.compose.animation.transition
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import com.example.recipeapp.R
import com.example.recipeapp.presentation.ui.compose.HeartAnimationDefinition.heartSize
import com.example.recipeapp.presentation.ui.compose.HeartAnimationDefinition.heartTransitionDefinition
import com.example.recipeapp.util.loadPicture


@Composable
fun AnimatedHeartButton(
    modifier: Modifier,
    buttonStates: MutableState<HeartAnimationDefinition.HeartButtonStates>,
    onToggle: () -> Unit,
){
    val toState = if(buttonStates.value == HeartAnimationDefinition.HeartButtonStates.IDLE){
        HeartAnimationDefinition.HeartButtonStates.ACTIVE
    }else{
        HeartAnimationDefinition.HeartButtonStates.IDLE
    }

    val state = transition(
        definition = heartTransitionDefinition,
        initState = buttonStates.value,
        toState = toState
    )

    HeartButton(modifier = modifier, buttonStates = buttonStates, state = state , onToggle = onToggle)
}

@Composable
private fun HeartButton(
    modifier: Modifier,
    buttonStates: MutableState<HeartAnimationDefinition.HeartButtonStates>,
    state: TransitionState,
    onToggle : () -> Unit,
) {
    if (buttonStates.value == HeartAnimationDefinition.HeartButtonStates.ACTIVE) {
        loadPicture(drawable = R.drawable.heart_grey).value?.let { image ->
            Image(
                bitmap = image.asImageBitmap(),
                modifier = modifier
                    .clickable(
                        onClick = onToggle,
                        indication = null,
                    )
                    .width(state[heartSize])
                    .height(state[heartSize])
                ,
            )
        }

    }else{
        loadPicture(drawable = R.drawable.heart_red).value?.let { image ->
            Image(
                bitmap = image.asImageBitmap(),
                modifier = modifier
                    .clickable(
                        onClick = onToggle,
                        indication = null,
                    )
                    .width(state[heartSize])
                    .height(state[heartSize])
                )
        }

    }
}


object HeartAnimationDefinition{
    enum class HeartButtonStates{
        IDLE, ACTIVE
    }

    private val idleIconSize = 50.dp
    private val expandedIconStyle = 80.dp

    val heartColor = ColorPropKey(label = "heartColor")
    val heartSize = DpPropKey("heartSize")

    @SuppressLint("Range")
    val heartTransitionDefinition = transitionDefinition<HeartButtonStates>{
        state(HeartButtonStates.IDLE){
            this[heartColor] = Color.LightGray
            this[heartSize] = idleIconSize
        }
        state(HeartButtonStates.ACTIVE){
            this[heartColor] = Color.Red
            this[heartSize] = idleIconSize
        }
        transition(HeartButtonStates.IDLE to HeartButtonStates.ACTIVE){
            heartColor using tween(durationMillis = 500)

            heartSize using keyframes {
                durationMillis = 500
                expandedIconStyle at 100
                idleIconSize at 200
            }

        }
        transition(HeartButtonStates.ACTIVE to HeartButtonStates.IDLE){
            heartColor using tween(durationMillis = 500)

            heartSize using keyframes {
                durationMillis = 500
                expandedIconStyle at 100
                idleIconSize at 200
            }

        }
    }
}
