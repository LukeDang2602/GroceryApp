package com.example.groceryapp.model.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.groceryapp.model.remote.datamodel.category.CategoryData
import com.example.groceryapp.model.remote.datamodel.product.ProductData
import com.example.groceryapp.model.remote.datamodel.registration.RegisterData
import com.example.groceryapp.model.remote.datamodel.subcategories.SubCategoryData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class Repository() : IRepository {
    private val remoteRepository = RemoteRepository()
    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override val userRegistrationData = MutableLiveData<RegisterData>()
    override val categories = MutableLiveData<List<CategoryData>>()
    override val subProducts = MutableLiveData<List<ProductData>>()
    override val subCategories = MutableLiveData<List<SubCategoryData>>()
    override fun registerUser() {
        val disposable = remoteRepository.registerUser(userRegistrationData.value)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({ res ->
                Log.i("register",res.message)
            },
                {
                    Log.i("register", it.message.toString())
                })
        if (disposable != null) {
            compositeDisposable.add(disposable)
        }
    }

    override fun getCategories() {
        val disposable = remoteRepository.getCategories()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({res ->
                Log.i("tag", res.error.toString())
                categories.value = res.data
            },
                {
                    Log.i("error", it.message.toString())
                })
        compositeDisposable.add(disposable)
    }
    override fun getSubProducts(subId: String) {
        val disposable = remoteRepository.getSubProducts(subId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({res ->
                Log.i("subProduct", "subProduct succeeded")
                subProducts.value = res.data
            },
                {
                    Log.i("subProduct", it.message.toString())
                })
        compositeDisposable.add(disposable)
    }

    override fun getSubCategories(catId: String) {
        val disposable = remoteRepository.getSubCategories(catId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({res ->
                Log.i("subCategories", "subCategories succeeded")
                subCategories.value = res.data
            },
                {
                    Log.i("subCategories", it.message.toString())
                })
        compositeDisposable.add(disposable)
    }


}


