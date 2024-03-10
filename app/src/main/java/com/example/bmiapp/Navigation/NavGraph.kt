package com.example.bmiapp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bmiapp.ResultScreen
import com.example.bmiapp.Screens.DetailScreen
import com.example.bmiapp.Screens.HomeScreen

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

        composable(route = "result/{height}/{weight}", arguments = listOf(
            navArgument(name = "height"){
            type = NavType.FloatType
        },
            navArgument(name = "weight"){
                type = NavType.IntType
            }


        )){backstackentry ->

            ResultScreen(Height = backstackentry.arguments?.getFloat("height"), Weight = backstackentry.arguments?.getInt("weight"), navController = navcontroller)
        }

    }
}