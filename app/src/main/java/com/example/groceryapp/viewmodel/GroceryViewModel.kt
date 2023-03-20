package com.example.groceryapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.groceryapp.model.remote.datamodel.category.CategoryData
import com.example.groceryapp.model.remote.datamodel.registration.RegisterData
import com.example.groceryapp.model.remote.datamodel.registration.RegisterResponse
import com.example.groceryapp.model.repository.Repository

class GroceryViewModel(
    application: Application,
    private val repository: Repository = Repository()
): AndroidViewModel(application) {
    val registerData: MutableLiveData<RegisterData> = repository.userRegistrationData
    val categories: LiveData<List<CategoryData>> = repository.categories

    fun registerUser(data: RegisterData){
        registerData.value = data
         repository.registerUser()
    }

    override fun onCleared() {
        super.onCleared()
        repository.compositeDisposable.dispose()
    }

    fun getCategories(){
        repository.getCategories()
    }



}