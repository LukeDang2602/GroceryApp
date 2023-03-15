package com.example.groceryapp.view.activities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.groceryapp.R
import com.example.groceryapp.databinding.ActivityLoginBinding
import com.example.groceryapp.model.remote.datamodel.RegisterData
import com.example.groceryapp.viewmodel.GroceryViewModel
import com.example.groceryapp.viewmodel.createFactory

class LoginActivity : AppCompatActivity() {
    private lateinit var viewModel: GroceryViewModel
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initViewModel()
        setUpObserver()
    }

    private fun initViewModel() {
        val factory = GroceryViewModel(application).createFactory()
        viewModel = ViewModelProvider(this,factory)[GroceryViewModel::class.java]
    }

    private fun setUpObserver() {
        viewModel.registerData.observe(this) {
            val userName = it.userName
            Toast.makeText(this, "$userName", Toast.LENGTH_SHORT).show()
        }
        viewModel.registerResponse.observe(this){
            Toast.makeText(this,"${it.message}",Toast.LENGTH_SHORT).show()
        }
    }

    private fun initView() {
        Glide.with(this)
            .load(R.drawable.flash_shop)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.groceryLogo)

        binding.signUpBtn.setOnClickListener {
            registerUser()
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