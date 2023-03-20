package com.example.groceryapp.view.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import com.bumptech.glide.Glide
import com.example.groceryapp.R
import com.example.groceryapp.databinding.CategoryItemBinding
import com.example.groceryapp.databinding.FragmentSplashBinding
import com.example.groceryapp.view.activities.MainActivity

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        initView()
        moveToLogin()
        return binding.root
    }

    private fun moveToLogin() {
        handler.postDelayed({
            (activity as MainActivity).openLoginFragment()
        },3000)

    }

    private fun initView() {
        Glide.with(this)
            .load(R.drawable.flash_shop)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.groceryLogo)
        animateGroceryLogo()
    }

    private fun animateGroceryLogo() {
        val logoAnim = AnimationUtils.loadAnimation(requireContext(),R.anim.translate_grocery_logo)

        binding.imageCard.startAnimation(logoAnim)
    }
}