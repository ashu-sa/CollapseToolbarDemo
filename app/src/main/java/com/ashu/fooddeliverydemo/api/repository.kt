package com.ashu.fooddeliverydemo.api

import com.ashu.fooddeliverydemo.data.VendorsItem
import retrofit2.Response

class repository {
    suspend fun getItem(): Response<VendorsItem> {
        return instance.api.getItems()
    }
}