package com.example.sendcolor

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sendcolor.model.ColorViewModel
import com.example.sendcolor.screen.ColorDetailsScreen
import com.example.sendcolor.screen.HexInputScreen

@Composable
fun AppNavigator(viewModel: ColorViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "hex_input") {
        composable("hex_input") {
            HexInputScreen(viewModel = viewModel, navController = navController)
        }

        composable("color_details") {

                ColorDetailsScreen(viewModel = viewModel)

        }
    }
}


