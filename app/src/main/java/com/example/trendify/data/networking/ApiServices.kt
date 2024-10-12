package com.example.trendify.data.networking

import com.example.trendify.data.model.AddOrDeleteCartRequest
import com.example.trendify.data.model.AddOrDeleteCartResponse
import com.example.trendify.data.model.AddOrDeleteFavRequest
import com.example.trendify.data.model.AddOrDeleteFavResponse
import com.example.trendify.data.model.CategoryProductsResponse
import com.example.trendify.data.model.CategoryResponse
import com.example.trendify.data.model.GetCartsResponse
import com.example.trendify.data.model.GetFavoritesResponse
import com.example.trendify.data.model.Home
import com.example.trendify.data.model.LoginRequest
import com.example.trendify.data.model.LoginResponse
import com.example.trendify.data.model.RegisterRequest
import com.example.trendify.data.model.RegisterResponse
import com.example.trendify.data.model.proudcts
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {

    //implementation network function
    @POST("User/Register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>
    @POST("User/Login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("home")
    suspend fun getHome():Response<Home>
    @GET("categories")
    suspend fun getCategory(): Response<CategoryResponse>
    @GET("products")
    suspend fun categoryProducts(@Query("category_id") category_id:String ): Response<CategoryProductsResponse>
    @GET("products/{id}")
    suspend fun getProductById(@Path("id")id:Int): Response<proudcts>

    @GET("favorites")
    suspend fun getFavorites():Response<GetFavoritesResponse>

    @POST("favorites")
    suspend fun addOrDeleteFavorite(@Body request: AddOrDeleteFavRequest):Response<AddOrDeleteFavResponse>

    @GET("carts")
    suspend fun getCarts():Response<GetCartsResponse>

    @POST("carts")
    suspend fun addOrDeleteCart(@Body request: AddOrDeleteCartRequest):Response<AddOrDeleteCartResponse>


}