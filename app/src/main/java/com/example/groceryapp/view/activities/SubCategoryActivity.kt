package com.example.groceryapp.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.groceryapp.databinding.ActivitySubCategoryBinding
import com.example.groceryapp.model.remote.datamodel.product.ProductData
import com.example.groceryapp.utils.Constants.CATEGORY_ID
import com.example.groceryapp.utils.Constants.CATEGORY_NAME
import com.example.groceryapp.view.adapters.CatProductAdapter
import com.example.groceryapp.viewmodel.GroceryViewModel
import com.example.groceryapp.viewmodel.createFactory

class SubCategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubCategoryBinding
    private lateinit var viewModel: GroceryViewModel
    private lateinit var catId: String
    private lateinit var catName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        setUpObserver()
        fetchProducts()
        initView()
    }

    private fun fetchProducts() {
        catId = intent.getIntExtra(CATEGORY_ID,0).toString()
        catName = intent.getStringExtra(CATEGORY_NAME).toString()
        if(catId != "0"){
            viewModel.getCatProducts(catId)
        }
    }

    private fun initViewModel() {
        val factory = GroceryViewModel(this@SubCategoryActivity.application).createFactory()
        viewModel = ViewModelProvider(this,factory)[GroceryViewModel::class.java]
    }

    private fun setUpObserver() {
        viewModel.catProducts.observe(this){
            binding.rvProducts.layoutManager = LinearLayoutManager(
                this@SubCategoryActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            binding.rvProducts.adapter = CatProductAdapter(it, this@SubCategoryActivity)
        }
    }

    private fun initView() {
        binding.catTitle.text = catName
        binding.btnBack.setOnClickListener {
            startActivity(Intent(applicationContext,MainActivity::class.java))
        }
    }

    fun addItemToCart(product: ProductData?) {
        if (product != null) {
            viewModel.addItemtoCart(product)
        }
    }
}