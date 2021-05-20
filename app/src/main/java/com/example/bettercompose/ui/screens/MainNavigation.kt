package com.example.bettercompose.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bettercompose.R
import com.example.bettercompose.ui.screens.allposts.AllPostsScreen
import com.example.bettercompose.ui.screens.newactivity.NewActivityScreen
import com.example.bettercompose.ui.screens.onboarding.OnboardingScreenFlow
import com.example.bettercompose.ui.screens.profile.ProfileScreen
import com.example.bettercompose.ui.theme.BetterComposeTheme

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
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(
             backgroundColor = MaterialTheme.colors.surface
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                listOfBottomNavItems.forEach {
                    BottomNavigationItem(
                        selected = currentRoute == it.route,
                        selectedContentColor = Color(0xFF000033),
                        unselectedContentColor = Color.LightGray,
                        onClick = {
                            navController.navigate(it.route) {
                                restoreState = true
                                launchSingleTop = true

                                navController.graph.startDestinationRoute?.let { startRoute ->
                                    popUpTo(startRoute) {
                                        saveState = true
                                    }
                                }
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = it.iconId),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    )
                }
            }
        } //end of bottom bar
    ) {
        NavHost(navController = navController, startDestination = Screens.AllPosts.route) {
            composable(Screens.AllPosts.route, content = { AllPostsScreen() })
            composable(Screens.NewTask.route, content = { NewActivityScreen() })
            composable(Screens.Profile.route, content = { ProfileScreen() })
        }
    }
}

sealed class Screens(val route: String, @DrawableRes val iconId: Int) {

    object AllPosts : Screens(route = "all_posts", R.drawable.ic_home)
    object NewTask : Screens(route = "new_task", R.drawable.ic_excellence)
    object Profile : Screens(route = "profile", R.drawable.ic_user)
}

val listOfBottomNavItems = listOf<Screens>(
    Screens.AllPosts,
    Screens.NewTask,
    Screens.Profile
)

@Preview
@Composable
fun MainNavigationPreview() {
    BetterComposeTheme {
        MainNavigation()
    }
}