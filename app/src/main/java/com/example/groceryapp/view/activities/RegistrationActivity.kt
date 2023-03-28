package com.example.groceryapp.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.groceryapp.databinding.ActivityRegistrationBinding
import com.example.groceryapp.model.remote.datamodel.registration.RegisterData
import com.example.groceryapp.viewmodel.GroceryViewModel
import com.example.groceryapp.viewmodel.createFactory

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var viewModel: GroceryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        initView()
    }

    private fun initView() {
        binding.btnGetStarted.setOnClickListener {
            registerUser()
        }
        binding.signIn.setOnClickListener {
            startActivity(Intent(this@RegistrationActivity,LoginActivity::class.java))
        }
    }

    private fun registerUser() {
        binding.apply {
            when {
                userNameInput.text.isEmpty() -> {
                    userNameInput.error = null
                    userNameInput.requestFocus()
                    showToast("Username is empty")
                }
                emailInput.text.isEmpty() -> {
                    emailInput.error = null
                    emailInput.requestFocus()
                    showToast("Email is empty")
                }
                mobileInput.text.isEmpty() -> {
                    mobileInput.error = null
                    mobileInput.requestFocus()
                    showToast("Mobile number is empty")
                }
                passwordInput.text.isEmpty() -> {
                    passwordInput.error = null
                    passwordInput.requestFocus()
                    showToast("Password is empty")
                }
                else -> {
                    val regData = RegisterData(
                        userNameInput.text.toString(),
                        emailInput.text.toString(),
                        mobileInput.text.toString(),
                        passwordInput.text.toString()
                    )
                    showToast("User registered successfully!!")
                    viewModel.registerUser(regData)
                    startActivity(Intent(this@RegistrationActivity,MainActivity::class.java))
                }
            }

        }
    }

    private fun initViewModel() {
        val factory = GroceryViewModel(this@RegistrationActivity.application).createFactory()
        viewModel = ViewModelProvider(this,factory)[GroceryViewModel::class.java]
    }

    private fun showToast(s: String) {
        Toast.makeText(this@RegistrationActivity, s, Toast.LENGTH_SHORT).show()
    }

}