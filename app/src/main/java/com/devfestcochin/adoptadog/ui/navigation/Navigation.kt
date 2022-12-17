package com.devfestcochin.adoptadog.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.devfestcochin.adoptadog.ui.screens.DetailsScreen
import com.devfestcochin.adoptadog.ui.screens.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable(route = "home") {
            HomeScreen(navController = navController)
        }

        composable(
            route = "details/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) {
            DetailsScreen(
                navController = navController,
                id = it.arguments?.getInt("id") ?: 0
            )
        }

    }
}