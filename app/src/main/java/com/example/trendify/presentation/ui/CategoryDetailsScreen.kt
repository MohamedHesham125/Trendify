package com.example.trendify.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import cafe.adriel.voyager.core.screen.Screen
import coil.compose.rememberImagePainter
import com.example.trendify.data.model.DataXXXXXX
import com.example.trendify.presentation.viewmodel.CategoryViewModel


class CategoryDetailsScreen( val id: Int) :Screen {
    @Composable
    override fun Content() {
        val viewModel: CategoryViewModel = hiltViewModel()
        viewModel.getCategoryById(id = id.toString())
        val categories = viewModel.detailscategories.collectAsState()
        CategoryDetailsScreenContent(products = categories.value)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDetailsScreenContent(products: List<DataXXXXXX>?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Category Details") },
                navigationIcon = {
                    IconButton (onClick = { /* Handle back button click */ }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {
            items(products ?: emptyList()) { product ->
                ProductItem(product = product)
            }
        }
    }
}

@Composable
fun ProductItem(product: DataXXXXXX?) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { /* Handle item click */ },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            Image(
                painter = rememberImagePainter(product?.image),
                contentDescription = product?.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = "${product?.name}", modifier = Modifier.padding(8.dp))
            Text(text = "Price: \$${product?.price}" , modifier = Modifier.padding(8.dp))
            Text(text = "${product?.description}",   modifier = Modifier.padding(8.dp))
            // Add more product details if needed
        }
    }
}


