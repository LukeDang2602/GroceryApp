package com.example.groceryapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.groceryapp.R
import com.example.groceryapp.databinding.ActivityLoginBinding
import com.example.groceryapp.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        Glide.with(this)
            .load(R.drawable.flash_shop)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.groceryLogo)
    }
}