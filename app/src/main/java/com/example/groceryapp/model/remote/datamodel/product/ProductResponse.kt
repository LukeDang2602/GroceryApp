package com.example.groceryapp.model.remote.datamodel.product

data class ProductResponse(
    val count: Int,
    val data: List<ProductData>,
    val error: Boolean
)