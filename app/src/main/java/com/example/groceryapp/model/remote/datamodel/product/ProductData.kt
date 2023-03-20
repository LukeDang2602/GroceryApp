package com.example.groceryapp.model.remote.datamodel.product

data class ProductData(
    val _id: String,
    val catId: Int,
    val description: String,
    val image: String,
    val mrp: Double,
    val position: Int,
    val price: Double,
    val productName: String,
    val quantity: Int,
    val status: Boolean,
    val subId: Int,
    val unit: String
)