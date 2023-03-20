package com.example.groceryapp.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.groceryapp.R
import com.example.groceryapp.databinding.ActivityMainBinding
import com.example.groceryapp.view.fragments.CategoryFragment
import com.example.groceryapp.view.fragments.LoginFragment
import com.example.groceryapp.view.fragments.RegisterFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun openLoginFragment(){
        fragmentManager.beginTransaction()
            .replace(R.id.splashFragment,LoginFragment())
            .addToBackStack(MainActivity.TAG_LOGIN)
            .commit()
    }
    fun openRegisterFragment() {
        RegisterFragment().show(fragmentManager, TAG_REGISTER)
    }

    fun openCategoryFragment(){
        fragmentManager.beginTransaction()
            .replace(R.id.splashFragment,CategoryFragment())
            .addToBackStack(MainActivity.TAG_CATEGORY)
            .commit()
    }

    companion object {
        const val TAG_LOGIN = "Login Fragment"
        const val TAG_CATEGORY = "Category Fragment"
        const val TAG_REGISTER = "Register Fragment"
    }
}