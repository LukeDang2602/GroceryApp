package com.example.groceryapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.groceryapp.R
import com.example.groceryapp.databinding.ActivityLoginBinding
import com.example.groceryapp.databinding.FragmentLoginBinding
import com.example.groceryapp.model.remote.datamodel.RegisterData
import com.example.groceryapp.view.activities.MainActivity
import com.example.groceryapp.viewmodel.GroceryViewModel
import com.example.groceryapp.viewmodel.createFactory


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: GroceryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        initViewModel()
        initView()
        return binding.root
    }

    private fun initViewModel() {
        val factory = GroceryViewModel(requireActivity().application).createFactory()
        viewModel = ViewModelProvider(this,factory)[GroceryViewModel::class.java]
    }

    private fun setUpObserver() {
        viewModel.registerData.observe(this) {
            val userName = it.userName
            Toast.makeText(this@LoginFragment.context, "$userName", Toast.LENGTH_SHORT).show()
        }
        viewModel.registerResponse.observe(this){
            Toast.makeText(this@LoginFragment.context,"${it.message}", Toast.LENGTH_SHORT).show()
        }
    }


    private fun initView() {
        Glide.with(this)
            .load(R.drawable.flash_shop)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.groceryLogo)

        binding.signUpBtn.setOnClickListener {
            registerUser()
            (activity as MainActivity).openCategoryFragment()
        }
    }

    private fun registerUser() {
        binding.apply {
            val regData = RegisterData(
                usernameInput.text.toString(),
                emailInput.text.toString(),
                mobileInput.text.toString(),
                passwordInput.text.toString()
            )
            viewModel.registerUser(regData)
        }
    }
}