package com.example.trendify.presentation.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import cafe.adriel.voyager.core.screen.Screen
import com.example.trendify.data.model.DataXXXXXXXX
import com.example.trendify.presentation.viewmodel.ProductsViewModel

class ProductsScreen(private val id: Int):Screen {
    @Composable
    override fun Content() {

        ProductsScreen(id.toString())
    }


    @SuppressLint("NotConstructor")
    @Composable
    fun ProductsScreen( id: String) {
        // Collect the state of product response and loading indicator
        val viewModel: ProductsViewModel = hiltViewModel()
        val productResponse = viewModel.detailsproductResponse.collectAsState()
        LaunchedEffect(Unit) {
            viewModel.getDetailsProducts(id)
        }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Products",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Check if products are loading

                val products = productResponse.value?.data

              //  if (products) {
                 //   Text(
                    //    text = "No products available.",
                    //    style = MaterialTheme.typography.bodyLarge
                   // )
            //    }
            //else
            //{
                Column {
                    ProductCard(product = products)

                    }
                }
            }
        }


    @Composable
    fun CircularProgressIndicator(modifier: Modifier) {
        TODO("Not yet implemented")
    }

    @Composable
    fun ProductCard(product: DataXXXXXXXX?) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Image(
                    painter = rememberImagePainter(product?.image),
                    contentDescription = product?.name,
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "${product?.name}",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = "$${product?.price}",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }



