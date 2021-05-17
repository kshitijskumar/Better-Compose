package com.example.bettercompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bettercompose.ui.theme.BetterComposeTheme
import com.example.bettercompose.ui.theme.Orange
import com.example.bettercompose.R
import com.example.bettercompose.ui.screens.components.OnBoardingCircleRow
import com.example.bettercompose.ui.screens.components.OnboardingPrevNextButtonSet

@Composable
fun OnboardingScreen1(onboardingState: MutableState<Int>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Orange)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(18.dp))
            Text(
                text = "Welcome to Better!",
                style = MaterialTheme.typography.h3,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(8.dp, 0.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_onboarding1),
                contentDescription = "Activity image",
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )

            Text(
                text = "You will daily get a productive activity to perform, may be try something you never tried, or to learn something new.",
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
                OnBoardingCircleRow(whichDot = 0)
                OnboardingPrevNextButtonSet(onboardingState)
            }
        }
    }
}




@Preview
@Composable
fun OnboardingPreview() {
    BetterComposeTheme {
//        OnboardingScreen1()
    }
}