package com.example.bettercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.bettercompose.ui.screens.OnboardingScreen1
import com.example.bettercompose.ui.screens.onboarding.OnboardingScreenFlow
import com.example.bettercompose.ui.theme.BetterComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BetterComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    OnboardingScreenFlow()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview()
@Composable
fun DefaultPreview() {
    BetterComposeTheme {
//        OnboardingScreen1(0)
        OnboardingScreenFlow()
    }
}