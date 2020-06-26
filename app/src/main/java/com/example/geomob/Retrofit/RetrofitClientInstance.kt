package com.example.geomob.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClientInstance {
    private lateinit var retrofit: Retrofit
    private const val BASE_URL = "https://en.wikipedia.org/"
    val getretrofitInstance: Retrofit
        get() {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
            return retrofit
        }
}