package com.example.log_train_app.components


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.log_train_app.R
import com.example.log_train_app.ui.theme.Primary
import com.example.log_train_app.ui.theme.TextColor


@Composable
fun NormalTextComponent(value: String, fontSize: TextUnit = 24.sp) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = fontSize,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center

    )
}


@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
//            .border(BorderStroke(1.dp, GrayColor), shape = RoundedCornerShape(50)),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(labelValue: String, icon: Painter) {
    val textValue = remember {
        mutableStateOf(value = "")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
        ),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Icon(painter = icon, contentDescription = "user img", Modifier.size(24.dp))
        }

    )


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(labelValue: String, icon: Painter) {
    val password = remember {
        mutableStateOf(value = "")
    }

    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = password.value,
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            Icon(painter = icon, contentDescription = "user img", Modifier.size(24.dp))
        },
        trailingIcon = {
            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }
            val description = if (passwordVisible.value) {
                stringResource(R.string.hide_password)
            } else {
                stringResource(R.string.show_password)
            }
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()

    )


}


@Composable
fun CheckBoxComponent(nav: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val checked = remember { mutableStateOf(false) }
        Checkbox(
            checked = checked.value,
            onCheckedChange = { isChecked -> checked.value = isChecked }
        )
        ClickableTextComponent(nav = nav)
    }
}

@Composable
fun ClickableTextComponent(nav: NavHostController) {
    val initialText = "By Continuing you accept our "
    val privacyPolicyText = "Privacy Policy"
    val andText = " and "
    val termsAndConditionsText = "Term of Use"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = termsAndConditionsText, annotation = termsAndConditionsText)
            append(termsAndConditionsText)
        }

    }

    ClickableText(text = annotatedString, onClick = { offset ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                if (span.tag == termsAndConditionsText){
                    nav.navigate("terms")
                }
            }

    })


}


@Composable
fun DynamicClickable_alreadyHaveAnAccount(navController: NavHostController) {
    val context = LocalContext.current
    val already = "Already Have An Account? "
    val signIn = "SignIn"

    val annotatedString = buildAnnotatedString {
        append(already)
        withStyle(SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = signIn, annotation = signIn)
            append(signIn)
        }

    }

    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center),
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    if (span.tag == signIn){
                        navController.navigate("screen1")
                    }
                }

        }
    )


}


@Composable
fun ComposableButton(value: String) {
    val context = LocalContext.current
    Button(modifier = Modifier.fillMaxWidth(),
        onClick = {
            Toast.makeText(context, "create Account", Toast.LENGTH_SHORT).show()
        }) {
        Text(text = value)
    }
}


@Composable
fun ORSpacer() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp), horizontalArrangement = Arrangement.Center
    ) {
        Spacer(
            modifier = Modifier
                .padding(end = 8.dp)
                .height(1.dp)
                .background(Primary)
                .width(100.dp)
                .align(Alignment.CenterVertically)
        )

        Text(text = "OR")

        Spacer(
            modifier = Modifier
                .padding(start = 8.dp)
                .height(1.dp)
                .background(Primary)
                .width(100.dp)
                .align(Alignment.CenterVertically)
        )
    }
}


@Composable
fun SignInWithCompose(navController: NavHostController) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        NormalTextComponent(value = "Sign In With", fontSize = 16.sp)
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.google),
                contentDescription = "google",
                modifier = Modifier
                    .padding(all = 16.dp)
                    .clickable {
                        Toast
                            .makeText(context, "google sign in action", Toast.LENGTH_SHORT)
                            .show()
                    })
            Image(painter = painterResource(id = R.drawable.facebook),
                contentDescription = "facebook",
                modifier = Modifier
                    .padding(all = 16.dp)
                    .clickable {
                        navController.navigate("bottom")
                    })
        }
    }
}


@Composable
fun DynamicClickable_DontHaveAnAccount(navController: NavHostController) {
val context = LocalContext.current
    val dontHaveAccount = stringResource(R.string.don_t_have_an_account)
    val creatAccount = stringResource(id = R.string.create_account)

    val annotatedString = buildAnnotatedString {
        append(dontHaveAccount)
        append(" ")
        withStyle(SpanStyle(color = Primary)){
            pushStringAnnotation(tag = creatAccount , annotation =  creatAccount)
            append(creatAccount)
        }
    }
    ClickableText(
        modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center),
        text = annotatedString,
        onClick = {offset->
            annotatedString.getStringAnnotations(offset,offset)
                .firstOrNull()?.also { span->
                    if (span.tag == creatAccount){
                        navController.navigate("screen2")
                    }
                }
        }
    )
}



