package com.example.groceryapp.model.remote.datamodel

import com.google.gson.annotations.SerializedName

data class RegisterData(
    val email: String,
    @SerializedName("firstName")
    val userName: String,
    val mobile: String,
    val password: String
)