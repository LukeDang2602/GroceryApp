package com.example.groceryapp.model.repository

import com.example.groceryapp.model.remote.APIService
import com.example.groceryapp.model.remote.datamodel.registration.RegisterData
import com.example.groceryapp.model.remote.RetrofitBuilder

class RemoteRepository(
    private val apiService: APIService = RetrofitBuilder.getRetrofit().create(APIService::class.java)
) {
    fun registerUser(value: RegisterData?) = value?.let { apiService.registerUser(it) }

    fun getCategories() = apiService.getCategories()

    fun getSubCategories(catId: String) = apiService.getsubCategories(catId)

    fun getCatProducts(catId: String) = apiService.getCatProducts(catId)

    fun getSubProducts(subId: String) = apiService.getSubProducts(subId)
}