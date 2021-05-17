package com.example.bettercompose.ui.screens.onboarding

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.bettercompose.ui.screens.OnboardingScreen1

@Composable
fun OnboardingScreenFlow() {

    val onboardingState = remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxSize()) {
        when(onboardingState.value) {
            0 -> OnboardingScreen1(onboardingState = onboardingState)
            1 -> OnboardingScreen2(onboardingState)
            2 -> OnboardingScreenFinal(onboardingState = onboardingState)
            else -> Toast.makeText(LocalContext.current, "Onboarding finished", Toast.LENGTH_SHORT).show()
        }
    }
}