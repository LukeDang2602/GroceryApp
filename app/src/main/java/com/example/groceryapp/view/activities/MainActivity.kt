package com.example.groceryapp.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.groceryapp.R
import com.example.groceryapp.databinding.ActivityMainBinding
import com.example.groceryapp.model.remote.datamodel.subcategories.SubCategoryData
import com.example.groceryapp.view.fragments.DashboardFragment
import com.example.groceryapp.view.fragments.LoginFragment
import com.example.groceryapp.view.fragments.RegisterFragment
import com.example.groceryapp.view.fragments.subcategories.BeefSubProductFragment
import com.example.groceryapp.view.fragments.subcategories.ChickenSubProductFragment
import com.example.groceryapp.view.fragments.subcategories.FruitSubProductFragment
import com.example.groceryapp.view.fragments.subcategories.VeggiesSubProductFragment

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
            .replace(R.id.splashFragment,DashboardFragment())
            .addToBackStack(MainActivity.TAG_CATEGORY)
            .commit()
    }

    fun openSubProductFragment(subCategoryData: List<SubCategoryData>) {
        for(data in subCategoryData){
            when(data.subId){
                1 -> fragmentManager.beginTransaction()
                    .replace(R.id.splashFragment, ChickenSubProductFragment(subCategoryData))
                    .addToBackStack(MainActivity.TAG_SUBCATEGORY)
                    .commit()
                2 -> fragmentManager.beginTransaction()
                    .replace(R.id.splashFragment,VeggiesSubProductFragment(subCategoryData))
                    .addToBackStack(MainActivity.TAG_SUBCATEGORY)
                    .commit()
                3 -> fragmentManager.beginTransaction()
                    .replace(R.id.splashFragment,FruitSubProductFragment(subCategoryData))
                    .addToBackStack(MainActivity.TAG_SUBCATEGORY)
                    .commit()
                4 -> fragmentManager.beginTransaction()
                    .replace(R.id.splashFragment,BeefSubProductFragment(subCategoryData))
                    .addToBackStack(MainActivity.TAG_SUBCATEGORY)
                    .commit()
            }
        }
    }

    companion object {
        const val TAG_LOGIN = "Login Fragment"
        const val TAG_CATEGORY = "Category Fragment"
        const val TAG_REGISTER = "Register Fragment"
        const val TAG_SUBCATEGORY = "SubCategory Fragment"
    }
}