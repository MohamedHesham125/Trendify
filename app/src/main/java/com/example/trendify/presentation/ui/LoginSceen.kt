package com.example.trendify.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.trendify.presentation.viewmodel.LoginViewModel

class LoginSceen : Screen {
    @Composable
    override fun Content() {
            val viewModel: LoginViewModel = hiltViewModel()
             val LoginResponse = viewModel.loginResponse.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        LoginScreen(onLoginClick =  { email, password ->
            viewModel.login(email = email, password = password, onLoginSuccess = {
                navigator.push(HomeScreen())

            })
        })


    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LoginScreen(onLoginClick:(String, String)->Unit) {
        var email by remember { mutableStateOf(TextFieldValue()) }
        var password by remember { mutableStateOf(TextFieldValue()) }
        var UserClicked by remember { mutableStateOf(false) }


        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Login") }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick ={
                        onLoginClick(email.text, password.text)
                        UserClicked = true
                    }



                ) {
                    Text("Login")
                }
            }
        }
    }
}