package com.example.jetpack_compose.ui.activity.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ForgetPasswordAuth(navController: NavHostController) {

    var email by remember {
        mutableStateOf("")
    }
    // Email TextField
    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Button(onClick = {
            // Handle forgot logic here
            println("Forgot password up with Username: $email")
            navController.navigate("dashboardScreen")
        }) {
            Text("Submit")
        }
    }
}