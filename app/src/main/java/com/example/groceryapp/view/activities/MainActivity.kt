package com.example.groceryapp.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.groceryapp.R
import com.example.groceryapp.databinding.ActivityMainBinding
import com.example.groceryapp.utils.Constants
import com.example.groceryapp.view.fragments.DashboardFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initBottomNavigation()
        setContentView(binding.root)
    }

    private fun initBottomNavigation() {
        binding.bottomNav.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.home -> homeFragment()
                R.id.search -> searchFragment()
                R.id.cart -> cartFragment()
            }
            true
        }
        homeFragment()
    }

    private fun cartFragment() {
        TODO("Not yet implemented")
    }

    private fun searchFragment() {
        TODO("Not yet implemented")
    }

    private fun homeFragment() {
        fragmentManager.beginTransaction()
            .replace(R.id.frameContainer, DashboardFragment())
            .commit()
    }

    fun moveToSubCategoryActivity(catId: Int, catName: String) {
        val intent = Intent(applicationContext,SubCategoryActivity::class.java)
        intent.putExtra(Constants.CATEGORY_ID, catId)
        intent.putExtra(Constants.CATEGORY_NAME, catName)
        startActivity(intent)
    }
}