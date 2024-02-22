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
import androidx.navigation.NavController

@Composable
fun SignUpAuth(navController : NavController) {
    // State for username and password
    var name by remember {
        mutableStateOf("")
    }
    var mobile by remember {
        mutableStateOf("")
    }
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirmpassword by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.padding(16.dp)) {
        // Username TextField
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = mobile,
            onValueChange = { mobile = it },
            label = { Text("Email") },
            modifier = Modifier.padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Mobile") },
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

        // Password TextField with password masking
        OutlinedTextField(
            value = confirmpassword,
            onValueChange = { confirmpassword = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Login Button
        Button(onClick = {
            // Handle login logic here
            println("Sign up with Username: $username, Password: $password")
           // navController.navigate("dashboardScreen")
        }) {
            Text("Sign Up")
        }
    }
}