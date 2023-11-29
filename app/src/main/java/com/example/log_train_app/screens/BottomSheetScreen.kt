package com.example.log_train_app.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.log_train_app.ui.theme.AccentColor
import com.example.log_train_app.ui.theme.Primary
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun BottomSheetScreen() {
    val sheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )

    val scope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent ={
                      Box(modifier = Modifier
                          .fillMaxWidth()
                          .height(300.dp),
                          contentAlignment = Alignment.Center
                      ){
                          Text(text = "BottomSheet", fontSize = 60.sp)
                      }
        },
        sheetBackgroundColor = AccentColor,
        sheetPeekHeight = 30.dp
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            Button(onClick = {
                scope.launch {
                    if (sheetState.isCollapsed){
                        sheetState.expand()
                    }else{
                        sheetState.collapse()
                    }
                }
            }) {
                Text(text = "open BottomSheet")
            }
        }
    }
}