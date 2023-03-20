package com.example.groceryapp.model.remote

import com.example.groceryapp.model.remote.datamodel.category.CategoryResponse
import com.example.groceryapp.model.remote.datamodel.product.ProductResponse
import com.example.groceryapp.model.remote.datamodel.registration.RegisterData
import com.example.groceryapp.model.remote.datamodel.registration.RegisterResponse
import com.example.groceryapp.model.remote.datamodel.subcategory.SubCategoryResponse
import com.example.groceryapp.utils.Constants
import com.example.groceryapp.utils.Constants.CATEGORY_ENDPOINT
import com.example.groceryapp.utils.Constants.REGISTER_ENDPOINT
import com.example.groceryapp.utils.Constants.SUBCATEGORY_ENDPOINT
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIService {

    @POST(REGISTER_ENDPOINT)
    fun registerUser(@Body registerData: RegisterData): Observable<RegisterResponse>
    @GET(CATEGORY_ENDPOINT)
    fun getCategories(): Single<CategoryResponse>

    @GET("$SUBCATEGORY_ENDPOINT{subId}")
    fun getSubCategories(@Path("subId") subId: String) : Single<SubCategoryResponse>

}