package com.example.groceryapp.model.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.groceryapp.model.remote.datamodel.RegisterData
import com.example.groceryapp.model.remote.datamodel.RegisterResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class Repository: IRepository {
    private val remoteRepository = RemoteRepository()
    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override val userRegistrationData = MutableLiveData<RegisterData>()
    val registrationResponse = MutableLiveData<RegisterResponse>()

    override fun registerUser() {
        val disposable = remoteRepository.registerUser(userRegistrationData.value)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({res ->
                registrationResponse.postValue(res)
            },
                {
                    Log.i("error", it.message.toString())
                })
        compositeDisposable.add(disposable)
    }
}


