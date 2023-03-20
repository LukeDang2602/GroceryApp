package com.example.groceryapp.model.remote.datamodel.category

data class CategoryResponse(
    val error: Boolean,
    val count: Int,
    val data: List<CategoryData>
)
