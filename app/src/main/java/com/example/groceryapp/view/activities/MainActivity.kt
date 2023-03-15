package com.example.groceryapp.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.groceryapp.R
import com.example.groceryapp.databinding.ActivityMainBinding
import com.example.groceryapp.view.fragments.CategoryFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var fragmentManager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun openCategoryFragment(){
        fragmentManager.beginTransaction()
            .replace(R.id.loginFragment,CategoryFragment())
            .addToBackStack(MainActivity.TAG_CATEGORY)
            .commit()

    }


    companion object {
        const val TAG_CATEGORY = "Category Fragment"
    }
}