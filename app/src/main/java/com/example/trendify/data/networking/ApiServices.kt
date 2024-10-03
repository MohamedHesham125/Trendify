package com.example.trendify.data.networking

import com.example.trendify.data.model.Home
import com.example.trendify.data.model.LoginRequest
import com.example.trendify.data.model.LoginResponse
import com.example.trendify.data.model.RegisterRequest
import com.example.trendify.data.model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServices {

    //implementation network function
    @POST("User/Register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>
    @POST("User/Login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("Home/Gethomedata")
    suspend fun getHome():Response<Home>

}