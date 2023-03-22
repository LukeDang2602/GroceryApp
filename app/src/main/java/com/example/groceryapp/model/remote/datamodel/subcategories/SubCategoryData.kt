package com.example.groceryapp.model.remote.datamodel.subcategories

data class SubCategoryData(
    val __v: Int,
    val _id: String,
    val catId: Int,
    val position: Int,
    val status: Boolean,
    val subDescription: String,
    val subId: Int,
    val subImage: String,
    val subName: String
)