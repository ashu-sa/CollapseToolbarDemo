package com.ashu.fooddeliverydemo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object instance {
    const val BASE_URL = "https://admin.t3al.net/"
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: ItemApi by lazy {
        getInstance().create(ItemApi::class.java)
    }
}