package com.example.groceryapp.model.remote.datamodel.subcategory

data class SubCategoryResponse(
    val count: Int,
    val data: List<SubCategoryData>,
    val error: Boolean
)