package com.example.groceryapp.model.remote.datamodel.subcategories

data class SubCategoryResponse(
    val count: Int,
    val data: List<SubCategoryData>,
    val error: Boolean
)