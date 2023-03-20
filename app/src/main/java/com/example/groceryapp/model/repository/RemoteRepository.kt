package com.example.groceryapp.model.repository

import com.example.groceryapp.model.remote.APIService
import com.example.groceryapp.model.remote.datamodel.registration.RegisterData
import com.example.groceryapp.model.remote.RetrofitBuilder
import com.example.groceryapp.model.remote.datamodel.registration.RegisterResponse
import com.example.groceryapp.model.remote.datamodel.subcategory.SubCategoryResponse
import io.reactivex.Observable
import io.reactivex.Single

class RemoteRepository(
    private val apiService: APIService = RetrofitBuilder.getRetrofit().create(APIService::class.java)
) {
    fun registerUser(value: RegisterData?) = value?.let { apiService.registerUser(it) }

    fun getCategories() = apiService.getCategories()

    fun getSubCategories(subId: String) : Single<SubCategoryResponse> {
        return apiService.getSubCategories(subId)
    }


}