package com.example.trendify.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.trendify.R

class SignUpScreen : Screen {
    @Composable
    override fun Content() {
        signupscreen()
    }

    @Composable
    fun signupscreen(){
        val name= remember { mutableStateOf("") }
        val phone= remember { mutableStateOf("") }
        val email= remember { mutableStateOf("") }
        val password= remember { mutableStateOf("") }
        val navigator= LocalNavigator.currentOrThrow

        Icon(imageVector = Icons.Filled.ArrowBack,
            contentDescription =null,
            modifier = Modifier.padding(top = 8.dp, start = 8.dp).clickable { navigator.push(SignUpScreen()) } )
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()) {
            Text(text = "Sign Up",
                fontFamily = FontFamily(Font(resId = R.font.poppins_bold)),
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 30.dp))

            Spacer(modifier = Modifier.height(70.dp))

            //Name TextField
            OutlinedTextField(
                value =name.value ,
                onValueChange ={name.value=it},
                modifier = Modifier
                    .width(343.dp)
                    .height(64.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xff6055D8),
                    unfocusedBorderColor = Color.White,
                    cursorColor = Color.Black,
                ),
                label = { Text(text = "Name",
                    color = Color(0xff9B9B9B))},
                textStyle = TextStyle(fontSize = 16.sp,
                    color = Color.Black),
            )

            Spacer(modifier = Modifier.height(30.dp))

            //Phone Number TextField
            OutlinedTextField(
                value =phone.value ,
                onValueChange ={phone.value=it},
                modifier = Modifier
                    .width(343.dp)
                    .height(64.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xff6055D8),
                    unfocusedBorderColor = Color.White,
                    cursorColor = Color.Black,
                ),
                label = { Text(text = "Phone Number",
                    color = Color(0xff9B9B9B))},
                textStyle = TextStyle(fontSize = 16.sp,
                    color = Color.Black),
            )

            Spacer(modifier = Modifier.height(30.dp))


            //Email Address TextField
            OutlinedTextField(
                value =email.value ,
                onValueChange ={email.value=it},
                modifier = Modifier
                    .width(343.dp)
                    .height(64.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xff6055D8),
                    unfocusedBorderColor = Color.White,
                    cursorColor = Color.Black
                ),
                label = { Text(text = "Email",
                    color = Color(0xff9B9B9B))},
                textStyle = TextStyle(fontSize = 16.sp,
                    color = Color.Black),
            )
            Spacer(modifier = Modifier.height(30.dp))

            //Password TextField
            OutlinedTextField(
                value =password.value ,
                onValueChange ={password.value=it},
                modifier = Modifier
                    .width(343.dp)
                    .height(64.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xff6055D8),
                    unfocusedBorderColor = Color.White,
                    cursorColor = Color.Black,
                ),
                label = { Text(text = "Password",
                    color = Color(0xff9B9B9B))},
                textStyle = TextStyle(fontSize = 16.sp,
                    color = Color.Black),
            )


            Spacer(modifier = Modifier.height(30.dp))



            //Recovery Password
            /*Row{
                Text(text = "Forget Password",
                    modifier = Modifier,
                    color = Color(0xff707B81),
                    fontFamily = FontFamily(Font(resId = R.font.poppins_light)),
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        tint = Color.Blue,
                        contentDescription = null)
            }
            }*/

            //Sign In Button
            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff6055D8),
                    contentColor = Color.White),
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .height(54.dp)
                    .width(335.dp)
            ) {
                Text(text = "Sign Up",
                    fontSize = 18.sp) }


            Spacer(modifier = Modifier.height(30.dp))
            Row() {
                Text(text = "Already have an account?")
                Icon(painter = painterResource(id = R.drawable.round_arrow_right_alt),
                    contentDescription =null,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(bottom = 10.dp)
                        .clickable { navigator.pop() },
                    tint = Color(0xff6055D8))
            }
            Spacer(modifier = Modifier.height(300.dp))
        }
    }
}