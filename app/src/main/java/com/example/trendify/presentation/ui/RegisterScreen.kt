package com.example.trendify.presentation.ui

import androidx.compose.animation.AnimatedVisibility
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
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.trendify.presentation.viewmodel.RegisterViewModel
import java.util.jar.Attributes.Name

class RegisterScreen :Screen {
    @Composable
    override fun Content() {
        val viewModel: RegisterViewModel = hiltViewModel()
        val RegisterResponse = viewModel.regitserResponse.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        RegistrationScreen( onRegisterClick = { name, Phone, email, password ->
            viewModel.register(
                Name = name,
                Email = email,
                Password = password,
                Phone = Phone,
                onRegiserterSuccess = {

                //navigtion to login
                navigator.push(LoginSceen())

            })
        })

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen( onRegisterClick:(String,Int, String, String)->Unit) {
    var name by remember { mutableStateOf(TextFieldValue()) }
    var Phone by remember { mutableStateOf(TextFieldValue()) }
    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    var UserClicked by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Register") }
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
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = Phone,
                onValueChange = { Phone = it },
                label = { Text("Phone") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

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
                onClick = {
                    UserClicked = true

                     /* onRegisterClick(
                          name = name.text,
                          Phone = Phone.text.toInt(),
                          email = email.text,
                          password = password.text
                      )*/


                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Register")
            }
            AnimatedVisibility(visible = UserClicked) {
                CircularProgressIndicator()

            }
        }
    }
}