package com.example.groceryapp.model.remote.datamodel.registration

import com.google.gson.annotations.SerializedName

data class RegisterData(
    val firstName: String = "",
    val email: String = "",
    val mobile: String = "",
    val password: String = ""
)