package com.example.bettercompose.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun OnboardingColoredCircles(shouldColor: Boolean = false) {

    val modifier = if (shouldColor) {
        Modifier
            .background(Color.White, CircleShape)
            .padding(2.dp)
            .size(10.dp)
            .clip(CircleShape)
    }else {
        Modifier
            .border(2.dp, Brush.linearGradient(listOf(Color.White, Color.White)), CircleShape)
            .padding(2.dp)
            .size(8.dp)
            .clip(CircleShape)
    }
    Box(
        modifier = modifier
    )

}

@Composable
fun OnBoardingCircleRow(totalDots: Int = 3, whichDot: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for(i in 0 until totalDots) {
            if(whichDot == i) {
                OnboardingColoredCircles(true)
            }else {
                OnboardingColoredCircles()
            }
            if(i != totalDots-1) {
                Spacer(modifier = Modifier.padding(8.dp))
            }

        }
    }

}

@Composable
fun OnboardingPrevNextButtonSet(shouldShowPrevious: Boolean = false, onStateChange: (Int) -> Unit, currState: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if(shouldShowPrevious) {
            TextButton(onClick = { onStateChange.invoke(currState - 1) }) {
                Text(text = "Previous", color = Color.White, style = MaterialTheme.typography.body1)
            }
        }else {
            TextButton(onClick = { onStateChange.invoke(4) }) {
                Text(text = "Skip", color = Color.White, style = MaterialTheme.typography.body1)
            }
        }

        TextButton(onClick = { onStateChange.invoke(currState + 1) }) {
            Text(text = "Next", color = Color.White, style = MaterialTheme.typography.body1)
        }
    }
}