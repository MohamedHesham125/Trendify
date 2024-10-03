package com.example.trendify.presentation.ui

<<<<<<< HEAD
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
=======
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import cafe.adriel.voyager.core.screen.Screen
import com.example.trendify.data.model.Banner
import com.example.trendify.data.model.proudcts
import com.example.trendify.presentation.viewmodel.HomeViewModel
>>>>>>> cartandcheckout

class HomeScreen : Screen {
    @Composable
    override fun Content() {
<<<<<<< HEAD
     homescreen()
    }
    @Composable
    fun homescreen(){
        
    }
}
=======
        val viewModel: HomeViewModel = hiltViewModel()
        val homeResponse = viewModel.HomeResponse.collectAsState()

        homeResponse.value?.data?.banners?.let { banners ->
            // Display the list of products if available
            LazyColumn {
                items(banners) { banner ->
                    HomeProductCard(product = banner)
                }
            }
        } ?: run {
            // Handle empty or loading state if necessary
            Text(text = "No banners available", modifier = Modifier.padding(16.dp))
        }
    }
}

@Composable
fun HomeProductCard(product: Banner) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            //Text(text = Banner.title ?: "Unknown Product", style = MaterialTheme.typography.titleMedium)
            // Uncomment and use price if available
            // Text(text = product.price ?: "No Price", style = MaterialTheme.typography.titleLarge)
           // Text(text = Banner.description ?: "No Description", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
>>>>>>> cartandcheckout
