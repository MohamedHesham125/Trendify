package com.example.trendify.presentation.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import coil.compose.AsyncImage
import com.example.trendify.data.model.Product
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.trendify.data.model.Banner
import com.example.trendify.presentation.viewmodel.HomeViewModel


class HomeScreen : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val viewModel: HomeViewModel = hiltViewModel()
        val homeResponse = viewModel.HomeResponse.collectAsState()
        var searchQuery by remember { mutableStateOf("") }

        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("Home Screen") },
                    navigationIcon = {
                        IconButton(onClick = { /* Handle menu click */ }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* Handle settings click */ }) {
                            Icon(Icons.Default.Settings, contentDescription = "Settings")
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFFFFA500)) // Orange color
                )
            },
            bottomBar = {
                BottomNavigationBar()
            }
        ) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {

                // Search Bar
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    label = { Text("Search Products") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )

                // LazyRow for Banners
                /*   homeResponse.value?.data?.banners?.let { banners ->
                       LazyRow(
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(vertical = 16.dp)
                       ) {
                           items(banners) { banner ->
                               BannerCard(banners = banner)
                           }
                       }
                   }*/

                // LazyColumn for Products
                homeResponse.value?.data?.products?.let { products ->
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(products.filter { product ->
                            product.name.contains(searchQuery, ignoreCase = true)
                        }) { product ->
                            HomeProductCard(products = product)
                        }
                    }
                } ?: run {
                    // Handle empty or loading state if necessary
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "No products available")
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Loading...")
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color.White // You can set the background color here
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            selected = true,
            onClick = { /* Handle home click */ }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
            selected = false,
            onClick = { /* Handle favorites click */ }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            selected = false,
            onClick = { /* Handle profile click */ }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Payment") },
            selected = false,
            onClick = { /* Handle payment click */ }
        )
    }
}

@Composable
fun HomeProductCard(products: Product) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            AsyncImage(
                model = products.image ?: "",
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .padding(end = 16.dp)
            )
            Column {
                Text(
                    text = products.name ?: "No Title",
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "Price: ${products.price}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF4CAF50) // Green color for price
                )
                Text(
                    text = "Old Price: ${products.old_price}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}

@Composable
fun BannerCard(banners: Banner) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .width(300.dp),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            AsyncImage(
                model = banners.image ?: "",
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().size(100.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = banners.product.toString() ?: "No Title",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = banners.category.toString() ?: "No Category",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
}
    }
}