package com.example.groceryapp.model.remote.datamodel.registration

data class RegisterResponse(
    val error: Boolean,
    val message: String,
    val data: List<RegisterData>
)
