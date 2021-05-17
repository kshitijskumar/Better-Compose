package com.example.bettercompose.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bettercompose.R
import com.example.bettercompose.ui.screens.components.OnBoardingCircleRow
import com.example.bettercompose.ui.screens.components.OnboardingPrevNextButtonSet
import com.example.bettercompose.ui.theme.BetterComposeTheme
import com.example.bettercompose.ui.theme.CreamPink

@Composable
fun OnboardingScreen2(onStateChange: (Int) -> Unit, currState: Int) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(CreamPink)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(28.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_doing_activity),
                contentDescription = "Activity image",
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )

            Spacer(modifier = Modifier
                .height(14.dp)
                .fillMaxWidth())

            Text(
                text = "Do that activity, learn something new, spend your time enjoying and learning. Share with the world through a photo.",
                style = MaterialTheme.typography.h5,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(14.dp, 0.dp),
                textAlign = TextAlign.Center
            )

            Column(
                modifier = Modifier
                    .padding(4.dp, 8.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ){
                OnBoardingCircleRow(whichDot = 1)
                OnboardingPrevNextButtonSet(true, onStateChange, currState)
            }
        }
    }

}

@Preview
@Composable
fun OnBoardingScreen2Preview() {
    BetterComposeTheme {
        val state = remember {
            mutableStateOf(1)
        }
        OnboardingScreen2({}, 1)
    }
}