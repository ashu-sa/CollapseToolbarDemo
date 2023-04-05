package com.ashu.fooddeliverydemo.api

import com.ashu.fooddeliverydemo.data.VendorsItem
import retrofit2.Response
import retrofit2.http.GET

interface ItemApi {
    @GET("api/v2/vendor-details?id=127&lang=en&user_id=")
    suspend fun getItems(): Response<VendorsItem>
}