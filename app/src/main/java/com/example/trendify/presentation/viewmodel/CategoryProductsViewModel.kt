package com.example.trendify.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.template.interceptor.AuthInterceptor
import com.example.trendify.data.model.CategoryProductsResponse
import com.example.trendify.data.model.CategoryResponse
import com.example.trendify.data.networking.ApiServices
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class CategoryProductsViewModel@Inject constructor(val  apiServices: ApiServices , val authInterceptor: AuthInterceptor): ViewModel() {
    private val _CategoryPronctsResponse = MutableStateFlow<CategoryProductsResponse?>(null)
    val CategoryProductsResponse: MutableStateFlow<CategoryProductsResponse?> get() = _CategoryPronctsResponse


    fun getCategoryProducts() {
        viewModelScope.launch {
            val response = apiServices.categoryProducts(category_id = String())
            if (response.isSuccessful) {
                _CategoryPronctsResponse.value = response.body()
            }

        }
    }
}