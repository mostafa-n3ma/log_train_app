package com.example.log_train_app.screens

import android.util.Log
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
import com.example.log_train_app.components.DynamicClickable_alreadyHaveAnAccount
import com.example.log_train_app.components.HeadingTextComponent
import com.example.log_train_app.components.MyTextField
import com.example.log_train_app.components.NormalTextComponent
import com.example.log_train_app.components.ORSpacer
import com.example.log_train_app.components.PasswordTextField
import com.example.log_train_app.components.SignInWithCompose

@Composable
fun SignUpScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Log.d("composeTest", "SignUpScreen:from the screen  ")
        Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
        ) {
            NormalTextComponent(value = stringResource(id = R.string.hello))
            HeadingTextComponent(value = stringResource(id = R.string.create_account))
            Spacer(modifier = Modifier.height(8.dp))
            MyTextField(
                labelValue = stringResource(id = R.string.first_name), icon = painterResource(
                    id = R.drawable.user
                )
            )
            MyTextField(
                labelValue = stringResource(id = R.string.last_name), icon = painterResource(
                    id = R.drawable.user
                )
            )
            MyTextField(
                labelValue = stringResource(id = R.string.email),
                icon = painterResource(id = R.drawable.email)
            )
            PasswordTextField(labelValue = stringResource(id = R.string.paswword) , icon = painterResource(
                id = R.drawable.password
            ))
            CheckBoxComponent(navController)
            Spacer(modifier = Modifier.height(20.dp))
            ComposableButton(value = "create Account")

            ORSpacer()

            SignInWithCompose(navController)


//           Spacer to push the text to the bottom
//            Spacer(modifier = Modifier.weight(1f))

            DynamicClickable_alreadyHaveAnAccount(navController)

        }

    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen() {
    SignUpScreen(navController = rememberNavController())
}