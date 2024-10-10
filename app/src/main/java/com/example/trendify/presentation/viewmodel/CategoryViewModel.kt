package com.example.trendify.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.template.interceptor.AuthInterceptor
import com.example.trendify.data.model.CategoryResponse
import com.example.trendify.data.model.Home
import com.example.trendify.data.networking.ApiServices
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class CategoryViewModel@Inject constructor(val  apiServices: ApiServices , val authInterceptor: AuthInterceptor): ViewModel() {
    private val _CategoryResponse = MutableStateFlow<CategoryResponse?>(null)
    val CategoryResponse: MutableStateFlow<CategoryResponse?> get() = _CategoryResponse

    fun getCategory() {
        viewModelScope.launch {
            val response = apiServices.getCategory()
            if (response.isSuccessful) {
                _CategoryResponse.value = response.body()
            }

        }
    }
}