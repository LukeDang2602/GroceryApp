package com.example.groceryapp.model.repository

import androidx.lifecycle.MutableLiveData
import com.example.groceryapp.model.remote.datamodel.category.CategoryData
import com.example.groceryapp.model.remote.datamodel.product.ProductData
import com.example.groceryapp.model.remote.datamodel.registration.RegisterData
import com.example.groceryapp.model.remote.datamodel.subcategories.SubCategoryData

interface IRepository {
    fun registerUser()
    fun getCategories()
    fun getCatProducts(catId: String)
    fun getSubProducts(subId: String)
    fun getSubCategories(catId: String)


    val userRegistrationData: MutableLiveData<RegisterData>
    val categories: MutableLiveData<List<CategoryData>>
    val subCategories: MutableLiveData<List<SubCategoryData>>
    val subProducts: MutableLiveData<List<ProductData>>
    val catProducts: MutableLiveData<List<ProductData>>
}