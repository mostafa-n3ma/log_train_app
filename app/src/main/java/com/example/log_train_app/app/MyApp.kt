package com.example.log_train_app.app

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.log_train_app.screens.SignInScreen
import com.example.log_train_app.screens.SignUpScreen
import com.example.log_train_app.screens.TermsAndConditionsScreen

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screen1"){
        composable("screen1"){
            SignInScreen(navController = navController)
            Log.d("composeTest", ": startingDestination = SignInScreen")
        }
        composable("screen2"){
            SignUpScreen(navController = navController)
            Log.d("composeTest ", ": startingDestination = SignUpScreen")
        }
        composable("terms"){
            TermsAndConditionsScreen(navController = navController)
            Log.d("composeTest MyApp", ": startingDestination = TermsAndConditionsScreen")

        }
    }
}