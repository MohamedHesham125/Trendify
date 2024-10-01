package com.example.trendify.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
//Design by Mohamed Ali
class AddShippingAddress : Screen {
    @Composable
    override fun Content() {
        addShippingAddress()
    }


}

@Composable
fun addShippingAddress(){

    var fullName = remember { mutableStateOf(TextFieldValue("")) }
    var address = remember { mutableStateOf(TextFieldValue("")) }
    var city = remember { mutableStateOf(TextFieldValue("")) }
    var state = remember { mutableStateOf(TextFieldValue("")) }
    var zipCode= remember { mutableStateOf(TextFieldValue("")) }
    var country = remember { mutableStateOf("United States") }

Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Adding Shipping Address",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center
        )

        OutlinedTextField(
            value = fullName.value,
            onValueChange = {
                fullName.value = it },
            label = { Text("Full name") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            )
        )
  OutlinedTextField(
            value = address.value,
            onValueChange = {
                address.value = it
                            },
            label = { Text("Address") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            )
        )

        OutlinedTextField(
            value = city.value,
            onValueChange = {
                city.value = it
                            },
            label = { Text("City") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            )
        )


        OutlinedTextField(
            value = state.value,
            onValueChange = { state.value = it },
            label = { Text("State/Province/Region") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            )
        )
  OutlinedTextField(
            value = zipCode.value,
            onValueChange = { zipCode.value = it },
            label = { Text("Zip Code (Postal Code)") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
        )

        OutlinedTextField(
            value = country.value,
            onValueChange = {},
            label = { Text("Country") },
            enabled = false,
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Save Address Action */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(  Color(0xFF6055d8))
        ) {
            Text(text = "SAVE ADDRESS", fontSize = 16.sp, color = Color.White)
        }
    }


}
//@Composable
//fun CustomisedOutLinedTextField(text:String, label:String){
//    val texted = remember { mutableStateOf(TextFieldValue(text)) }
//
//    OutlinedTextField(
//        value = texted.value,
//        onValueChange = {
//            texted.value = it },
//        label = { Text(label) },
//        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
//        keyboardOptions = KeyboardOptions.Default.copy(
//            keyboardType = KeyboardType.Number,
//            imeAction = ImeAction.Next
//        )
//    )
//
//
//}