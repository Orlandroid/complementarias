package com.example.app_004_complementariasmx.data.api

import com.example.app_004_complementariasmx.domain.modelo.remote.LoginRequest
import com.example.app_004_complementariasmx.domain.modelo.remote.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface FakeStoreService {

    @POST("auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
}