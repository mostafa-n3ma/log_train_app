package com.example.log_train_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.log_train_app.R
import com.example.log_train_app.components.CheckBoxComponent
import com.example.log_train_app.components.ComposableButton
import com.example.log_train_app.components.DynamicClickable_DontHaveAnAccount
import com.example.log_train_app.components.HeadingTextComponent
import com.example.log_train_app.components.MyTextField
import com.example.log_train_app.components.NormalTextComponent
import com.example.log_train_app.components.ORSpacer
import com.example.log_train_app.components.PasswordTextField
import com.example.log_train_app.components.SignInWithCompose


@Composable
fun SignInScreen(navController:NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(all = 16.dp)
    ) {
        Column (
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            NormalTextComponent(value = stringResource(R.string.welcome_back))
            HeadingTextComponent(value = stringResource(R.string.signin))

            Spacer(modifier = Modifier.height(16.dp))

            MyTextField(labelValue = "Email", icon = painterResource(id = R.drawable.email))
            PasswordTextField(labelValue = stringResource(id = R.string.paswword), icon = painterResource(id = R.drawable.password))

            CheckBoxComponent( nav=navController)
            Spacer(modifier = Modifier.height(20.dp))
            ComposableButton(value = stringResource(R.string.sign_in))
            ORSpacer()
            SignInWithCompose()

            DynamicClickable_DontHaveAnAccount(navController)
            
        }

    }
}



@Preview
@Composable
fun SignInScreenPreview() {
    SignInScreen(navController = rememberNavController())
}