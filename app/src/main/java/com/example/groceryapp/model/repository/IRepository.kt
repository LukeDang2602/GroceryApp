package com.example.groceryapp.model.repository

import androidx.lifecycle.MutableLiveData
import com.example.groceryapp.model.remote.datamodel.category.CategoryData
import com.example.groceryapp.model.remote.datamodel.registration.RegisterData
import com.example.groceryapp.model.remote.datamodel.registration.RegisterResponse
import com.example.groceryapp.model.remote.datamodel.subcategory.SubCategoryData
import com.example.groceryapp.model.remote.datamodel.subcategory.SubCategoryResponse
import io.reactivex.Single

interface IRepository {
    fun registerUser()
    fun getCategories()
    //fun getSubCategories(catId: String): Single<SubCategoryResponse>

    val userRegistrationData: MutableLiveData<RegisterData>
    val categories: MutableLiveData<List<CategoryData>>
    val subcategories: MutableLiveData<List<SubCategoryData>>
}