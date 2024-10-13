package com.example.trendify.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import com.example.trendify.data.model.proudcts

class CartScreen : Screen{
    @Composable
    override fun Content() {
        cartScreen(products = )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun cartScreen(products: List<proudcts>, oncheckoutclicked:(Int)-> Unit) {
        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* TODO: Handle more options */ }) {
                            Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "More options")
                        }
                    },
                    title = {
                        Box(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "Cart",
                                modifier = Modifier.align(Alignment.Center),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            LazyColumn(
                contentPadding = paddingValues
            ) {
                items(products) { product ->
                    Column(modifier = Modifier.padding(16.dp)) {
                        Card(modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()) {
                            Row(modifier = Modifier.padding(16.dp)) {
                                Image(
                                    painter = painterResource(id = androidx.core.R.drawable.ic_call_answer_video),
                                    contentDescription = null
                                )
                                Spacer(modifier = Modifier.width(24.dp))
                                Column {
                                    Text(text = product.Name)
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text(text = product.Price)
                                }
                            }
                        }
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {  },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(text = "Checkout")
                    }
                }
            }
        }
    }
}