package com.example.log_train_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.log_train_app.components.HeadingTextComponent

@Composable
fun TermsAndConditionsScreen(navController: NavHostController){
    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(all = 16.dp),
    ) {
        HeadingTextComponent(value = "This IS Terms And Conditions Screen")

    }
}


@Preview
@Composable
fun TermsScreenPreview(){
    TermsAndConditionsScreen(navController = rememberNavController())
}