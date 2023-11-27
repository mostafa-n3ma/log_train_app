package com.example.log_train_app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.log_train_app.app.MyApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d( "composeTest onCreate:"," MainActivity")
        setContent {
            MyApp()

        }
    }
}
