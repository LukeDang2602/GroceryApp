package com.example.groceryapp.model.remote

import com.example.groceryapp.utils.Constants.TOKEN
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor: Interceptor{

    override fun intercept(chain: Interceptor.Chain): Response {
        val currentRequest = chain.request().newBuilder()
        currentRequest.addHeader("token", TOKEN)

        val newRequest = currentRequest.build()
        return chain.proceed(newRequest)
    }

}