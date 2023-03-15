package com.example.groceryapp.model.remote.datamodel

data class RegisterResponse(
    val error: Boolean,
    val message: String,
    val data: RegisterData
)
