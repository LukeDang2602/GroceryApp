package com.example.groceryapp.model.repository

import androidx.lifecycle.MutableLiveData
import com.example.groceryapp.model.remote.APIService
import com.example.groceryapp.model.remote.datamodel.RegisterData
import com.example.groceryapp.model.remote.RetrofitBuilder
import com.example.groceryapp.model.remote.datamodel.RegisterResponse
import io.reactivex.Observable
import io.reactivex.Single

class RemoteRepository(
    private val apiService: APIService = RetrofitBuilder.getRetrofit().create(APIService::class.java)
) {
    private lateinit var response: Observable<RegisterResponse>
    fun registerUser(value: RegisterData?): Observable<RegisterResponse> {
        if (value != null) {
            response = apiService.registerUser(
                value.userName,
                value.email,
                value.mobile,
                value.password
            )
        }
        return response
    }
}