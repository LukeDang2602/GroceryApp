package com.example.groceryapp.model.remote

data class RegisterResponse(
    val `data`: Data,
    val error: Boolean,
    val message: String
)
