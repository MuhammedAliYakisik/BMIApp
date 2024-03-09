package com.example.bmiapp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bmiapp.ResultScreen
import com.example.bmiapp.Screens.DetailScreen
import com.example.bmiapp.Screens.HomeScreen
import kotlinx.coroutines.flow.combine

@Composable
fun NavigatonGraph(){


    val navcontroller = rememberNavController()

    NavHost(navController = navcontroller, startDestination = "home") {

        composable(route = "home"){
            HomeScreen(navcontroller)

        }
        composable(route = "detail"){
            DetailScreen(navcontroller)

        }

        composable(route = "result"){
            ResultScreen(navcontroller)
        }

    }
}