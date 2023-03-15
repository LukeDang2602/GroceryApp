package com.example.groceryapp.model.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.groceryapp.model.remote.datamodel.RegisterData

interface IRepository {
    fun registerUser()

    val userRegistrationData: MutableLiveData<RegisterData>
}