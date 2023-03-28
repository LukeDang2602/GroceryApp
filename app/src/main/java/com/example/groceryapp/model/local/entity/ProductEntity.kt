package com.example.groceryapp.model.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductEntity(
    @PrimaryKey(autoGenerate = true) val index: Int,
    val productName: String = "",
    val quantity: Int = 0,
    val price: Float = 0F,
    val description: String = "",
    val productImg: String = ""
)
