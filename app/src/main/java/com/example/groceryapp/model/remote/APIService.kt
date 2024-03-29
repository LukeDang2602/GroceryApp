package com.example.groceryapp.model.remote

import com.example.groceryapp.model.remote.datamodel.category.CategoryResponse
import com.example.groceryapp.model.remote.datamodel.product.ProductResponse
import com.example.groceryapp.model.remote.datamodel.registration.RegisterData
import com.example.groceryapp.model.remote.datamodel.registration.RegisterResponse
import com.example.groceryapp.model.remote.datamodel.subcategories.SubCategoryResponse
import com.example.groceryapp.utils.Constants.CATEGORY_ENDPOINT
import com.example.groceryapp.utils.Constants.CATPRODUCT_ENDPOINT
import com.example.groceryapp.utils.Constants.REGISTER_ENDPOINT
import com.example.groceryapp.utils.Constants.SUBCATEGORY_ENDPOINT
import com.example.groceryapp.utils.Constants.SUBPRODUCT_ENDPOINT
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
    @GET("$SUBCATEGORY_ENDPOINT{catId}")
    fun getsubCategories(@Path("catId") catId: String): Single<SubCategoryResponse>
    @GET("$CATPRODUCT_ENDPOINT{catId}")
    fun getCatProducts(@Path("catId")catId: String): Single<ProductResponse>
    @GET("$SUBPRODUCT_ENDPOINT{subId}")
    fun getSubProducts(@Path("subId") subId: String) : Observable<ProductResponse>
}