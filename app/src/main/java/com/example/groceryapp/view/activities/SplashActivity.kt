package com.example.groceryapp.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import com.bumptech.glide.Glide
import com.example.groceryapp.R
import com.example.groceryapp.databinding.ActivitySplashBinding
import com.example.groceryapp.utils.Constants.SPLASH_SCREEN

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        initView()
        setContentView(binding.root)
    }

    private fun initView() {
        Glide.with(this)
            .load(R.drawable.flash_shop)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.groceryLogo)
        animateGroceryLogo()
        moveToLogin()
    }

    private fun moveToLogin() {
        handler.postDelayed({
            startActivity(Intent(applicationContext,LoginActivity::class.java))
        },SPLASH_SCREEN)
    }

    private fun animateGroceryLogo() {
        val logoAnim = AnimationUtils.loadAnimation(this,R.anim.translate_grocery_logo)
        binding.imageCard.startAnimation(logoAnim)
    }
}