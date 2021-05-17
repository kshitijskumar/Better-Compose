package com.example.bettercompose.ui.screens.onboarding

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.bettercompose.ui.screens.MainNavigation
import com.example.bettercompose.ui.screens.OnboardingScreen1

@Composable
fun OnboardingScreenFlow() {

    var onboardingState by remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxSize()) {
        when(onboardingState) {
            0 -> OnboardingScreen1(0){ onboardingState = it}
            1 -> OnboardingScreen2({ onboardingState = it }, 1)
            2 -> OnboardingScreenFinal({ onboardingState = it }, 2)
            else -> MainNavigation()
        }
    }
}