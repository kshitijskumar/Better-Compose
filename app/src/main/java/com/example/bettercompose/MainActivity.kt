package com.example.bettercompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.bettercompose.ui.screens.StartScreen
import com.example.bettercompose.ui.screens.onboarding.OnboardingScreenFlow
import com.example.bettercompose.ui.theme.BetterComposeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BetterComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val isFirstTime = Random.nextBoolean()
                    Log.d("MainActivity", "IsFirstTime: $isFirstTime")
                    StartScreen(isFirstTime)
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