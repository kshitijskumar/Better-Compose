package com.example.bettercompose.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.bettercompose.ui.screens.onboarding.OnboardingScreenFlow

@Composable
fun StartScreen(isFirstTime: Boolean = false) {
    if (isFirstTime) {
        OnboardingScreenFlow()
    }else {
        MainNavigation()
    }
}

@Composable
fun MainNavigation() {
    Text(text = "Main Navigation")
}