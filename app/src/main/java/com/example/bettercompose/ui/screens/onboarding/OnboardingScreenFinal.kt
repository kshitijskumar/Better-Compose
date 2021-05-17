package com.example.bettercompose.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import com.example.bettercompose.ui.theme.BetterComposeTheme
import com.example.bettercompose.ui.theme.Green

@Composable
fun OnboardingScreenFinal(onboardingState: MutableState<Int>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Green)
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
                painter = painterResource(id = R.drawable.ic_final_onboarding),
                contentDescription = "App final onboarding screen",
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )

            Spacer(modifier = Modifier
                .height(32.dp)
                .fillMaxWidth())

            Text(
                text = """Better,
                    |will help you grow your skills and build your well being.""".trimMargin(),
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

                Button(
                    onClick = { onboardingState.value = onboardingState.value + 1 },
                    modifier = Modifier
                        .padding(18.dp, 50.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    shape = RoundedCornerShape(24.dp)

                ) {
                    Text (
                        text = "Start your streak",
                        style = MaterialTheme.typography.h6,
                        color = Color.Black,
                        modifier = Modifier.padding(0.dp, 8.dp)
                    )
                }
                OnBoardingCircleRow(whichDot = 2)
            }
        }
    }


}

@Preview
@Composable
fun OnBoardingScreenFinalPreview() {
    BetterComposeTheme {
        val state = remember {
            mutableStateOf(2)
        }
        OnboardingScreenFinal(onboardingState = state)
    }
}