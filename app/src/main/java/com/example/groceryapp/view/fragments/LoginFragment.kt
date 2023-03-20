package com.example.groceryapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.groceryapp.R
import com.example.groceryapp.databinding.FragmentLoginBinding
import com.example.groceryapp.model.remote.datamodel.registration.RegisterData
import com.example.groceryapp.view.activities.MainActivity
import com.example.groceryapp.viewmodel.GroceryViewModel
import com.example.groceryapp.viewmodel.createFactory
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: GroceryViewModel
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseUser: FirebaseUser

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        initViewModel()
        initView()
        initFirebase()
        return binding.root
    }
    private fun initFirebase() {
        firebaseAuth = FirebaseAuth.getInstance()
        if (firebaseAuth.currentUser != null) {
            firebaseUser = firebaseAuth.currentUser!!
        }
    }


    private fun initViewModel() {
        val factory = GroceryViewModel(requireActivity().application).createFactory()
        viewModel = ViewModelProvider(this,factory)[GroceryViewModel::class.java]
    }

    private fun initView() {
        binding.signInBtn.setOnClickListener {
            loginUser()
            (activity as MainActivity).openCategoryFragment()
        }

        binding.dontHaveAccount.setOnClickListener {
            //Toast.makeText(this@LoginFragment.context, "You clicked", Toast.LENGTH_SHORT).show()
            (activity as MainActivity).openRegisterFragment()
        }
    }

    private fun loginUser() {
        val email = binding.emailInput.text.toString()
        val password = binding.passwordInput.text.toString()

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    showToast("User logged in successfully!!")
                } else {
                    showToast("User credential failed!!")
                }
            }
    }
    private fun showToast(s: String) {
        Toast.makeText(requireContext(), s, Toast.LENGTH_SHORT).show()
    }

    /*private fun registerUser(): Boolean {
        var success = false
        binding.apply {
            val regData = RegisterData(
                usernameInput.text.toString(),
                emailInput.text.toString(),
                mobileInput.text.toString(),
                passwordInput.text.toString()
            )
            success = viewModel.registerUser(regData)
        }
        return success
    }*/
}