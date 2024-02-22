package com.example.jetpack_compose.ui.activity.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {
    // State for username and password
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.padding(16.dp)) {
        // Username TextField
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Password TextField with password masking
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Login Button
        Button(onClick = {
            // Handle login logic here
            println("Login with Username: $username, Password: $password")
            navController.navigate("dashboardScreen")
        }) {
            Text("Login")
        }

        SignUpText(onSignUpClick = {
            navController.navigate("signUpScreen")
        })

        ForgetText(onForgetClick = {
            navController.navigate("forgotScreen")
        })
    }
}

@Composable
fun SignUpText(onSignUpClick: () -> Unit) {
    val annotatedText = buildAnnotatedString {
        append("Don't have an account? ")

        // Push a style that includes an underline and makes it clickable
        pushStringAnnotation(tag = "SIGN_UP", annotation = "Sign Up")
        withStyle(
            style = SpanStyle(fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline)
        ) {
            append("Sign Up")
        }
        pop() // Pop the style to not apply to any text appended after this
    }

    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            annotatedText.getStringAnnotations(tag = "SIGN_UP", start = offset, end = offset)
                .firstOrNull()?.let {
                    // Handle sign up click here
                    onSignUpClick()
                }
        }
    )
}

@Composable
fun ForgetText(onForgetClick: () -> Unit) {
    // Create an annotated string with a specific tag for the clickable part
    val annotatedText = buildAnnotatedString {
        // Add a clickable annotation with a tag
        pushStringAnnotation(tag = "FORGET", annotation = "Forgot Password")
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append("Forgot Password")
        }
        pop() // Make sure to pop the annotation to end its application
    }

    // Use ClickableText with an onClick listener that checks for the annotation tag
    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            // Check if the click is within the "FORGET" annotated range
            annotatedText.getStringAnnotations(tag = "FORGET", start = offset, end = offset)
                .firstOrNull()?.let {
                    // If yes, execute the provided callback
                    onForgetClick()
                }
        }
    )
}