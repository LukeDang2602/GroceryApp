package com.example.groceryapp.model.remote

import com.example.groceryapp.model.remote.datamodel.RegisterResponse
import com.example.groceryapp.utils.Constants
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIService {

    @FormUrlEncoded
    @POST(Constants.REGISTER_ENDPOINT)
    fun registerUser(
        @Field("firstName") userName: String,
        @Field("email") email: String,
        @Field("mobile") mobile: String,
        @Field("password") password: String
    ): Observable<RegisterResponse>
}