package com.example.trendify.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.trendify.R

class LoginSceen : Screen {
    @Composable
    override fun Content() {
        loginscreen()
    }


    @Composable
    fun loginscreen(){
        val username= remember { mutableStateOf("") }
        val password= remember { mutableStateOf("") }
        val navigator= LocalNavigator.currentOrThrow


        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()) {
            Row {
                IconButton(onClick = {null}) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = null)
                }
                Text(
                    text = "Sign In",
                    fontSize = 28.sp,
                    modifier = Modifier.padding(top = 50.dp)
                )
            }


            //Email Address TextField
            Text(text = "Email Address", modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp),
                fontSize = 16.sp,
            )

            Box(modifier = Modifier.fillMaxWidth()){
                OutlinedTextField(
                    value =username.value ,
                    onValueChange ={username.value=it},
                    modifier = Modifier
                        .width(343.dp)
                        .height(64.dp)
                        .padding(start = 16.dp, end = 16.dp, top = 231.dp, bottom = 8.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xff5B9EE1),
                        unfocusedBorderColor = Color.Gray,
                    ),
                    placeholder = { Text(text = "Name")}
                )
            }
            Spacer(modifier = Modifier.height(30.dp))



            //Password TextField
            Box(modifier = Modifier.fillMaxWidth()){
                OutlinedTextField(
                    value =password.value ,
                    onValueChange ={password.value=it},
                    modifier = Modifier
                        .width(343.dp)
                        .height(64.dp)
                        .padding(start = 16.dp, end = 16.dp, top = 231.dp, bottom = 8.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xff5B9EE1),
                        unfocusedBorderColor = Color.Gray,
                    )
                )
            }

            Spacer(modifier = Modifier.height(30.dp))



            //Recovery Password
           /* Box(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
                Text(text = "Recovery Password",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .clickable { navigator.push(ForgetPasswordScreen()) },
                    color = Color(0xff707B81),
                    fontFamily = FontFamily(Font(resId = R.font.airbnbcereal_w_bk)),
                )
            }*/

            //Sign In
           /* Button(onClick = { navigator.push(SignUpScreen()) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff5B9EE1),
                    contentColor = Color.White),
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .height(54.dp)
                    .width(335.dp)
            )
            {
                Text(text = "Sign In",
                    fontSize = 18.sp)
            }*/
            Spacer(modifier = Modifier.height(200.dp))

            Row {
                Text(text = "Don't have an account?")
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "Signup Free",
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .clickable { navigator.push(SignUpScreen()) })
            }
        }
    }
}