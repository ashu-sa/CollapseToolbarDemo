package com.ashu.fooddeliverydemo.data

import com.ashu.fooddeliverydemo.data.Item

data class VendorsItem(
    val items: List<Item>,
    val vendor_category_id: Int,
    val vendor_category_name: String
)