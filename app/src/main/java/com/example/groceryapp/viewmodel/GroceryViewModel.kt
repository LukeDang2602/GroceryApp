package com.example.groceryapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.groceryapp.model.remote.datamodel.RegisterData
import com.example.groceryapp.model.remote.datamodel.RegisterResponse
import com.example.groceryapp.model.repository.Repository

class GroceryViewModel(
    application: Application,
    private val repository: Repository = Repository()
): AndroidViewModel(application) {
    val registerData: MutableLiveData<RegisterData> = repository.userRegistrationData
    val registerResponse: MutableLiveData<RegisterResponse> = repository.registrationResponse

    fun registerUser(data: RegisterData){
        registerData.value = data
        repository.registerUser()
    }
    fun getResponse(): RegisterResponse? {
        return registerResponse.value
    }
    override fun onCleared() {
        super.onCleared()
        repository.compositeDisposable.dispose()
    }
}