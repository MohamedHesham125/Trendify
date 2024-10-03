package com.example.trendify.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.trendify.data.model.proudcts

class Cart : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val products = listOf(
            proudcts(R.id.accessibility_custom_action_0, "Camera", "Nikon", "400$"),
            proudcts(R.id.wrapped_composition_tag, "Lapyop ", "Mac", "599$"),
            proudcts(R.id.accessibility_custom_action_0, "Apple", "Iphone", "999$"),
            proudcts(R.id.accessibility_custom_action_2, "ThShirt", "Name 3", "20$"),
        )
        val navigator = LocalNavigator.currentOrThrow

        CartScreen(products = products, navigator = navigator)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(products: List<proudcts> , navigator: Navigator) {
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
                    onClick = { navigator.push(Checkout()) },
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
