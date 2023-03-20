package com.example.groceryapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.groceryapp.R
import com.example.groceryapp.databinding.FragmentRegisterBinding
import com.example.groceryapp.model.remote.datamodel.registration.RegisterData
import com.example.groceryapp.view.activities.MainActivity
import com.example.groceryapp.viewmodel.GroceryViewModel
import com.example.groceryapp.viewmodel.createFactory
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegisterFragment : DialogFragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewModel: GroceryViewModel
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseUser: FirebaseUser

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        initViewModel()
        initFirebase()
        return binding.root
    }

    private fun initViewModel() {
        val factory = GroceryViewModel(requireActivity().application).createFactory()
        viewModel = ViewModelProvider(this,factory)[GroceryViewModel::class.java]
    }

    private fun initFirebase() {
        firebaseAuth = FirebaseAuth.getInstance()
        if (firebaseAuth.currentUser != null) {
            firebaseUser = firebaseAuth.currentUser!!
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signUpBtn.setOnClickListener{
            registerUser()
            (activity as MainActivity).openCategoryFragment()
            dialog?.dismiss()
        }
        binding.cancelBtn.setOnClickListener {
            dialog?.dismiss()
        }
    }
    override fun onResume() {
        super.onResume()
        customizeDialog()
    }

    override fun onStop() {
        super.onStop()
        customizeDialog()
    }

    private fun customizeDialog() {
        val params = dialog?.window?.attributes
        params?.height = WindowManager.LayoutParams.MATCH_PARENT
        params?.width = WindowManager.LayoutParams.MATCH_PARENT
        dialog?.window?.apply{
            setBackgroundDrawableResource(R.drawable.round_corner)
            attributes = params
        }
    }

    private fun registerUser() {
        binding.apply {
            val regData = RegisterData(
                firstNameInput.text.toString(),
                emailInput.text.toString(),
                mobileInput.text.toString(),
                passwordInput.text.toString()
            )
            showToast("User registered successfully!!")
            //registerUseFirebase(regData)
            viewModel.registerUser(regData)
        }
    }

    private fun registerUseFirebase(regData: RegisterData) {
        val email = regData.email.toString()
        val password = regData.password.toString()

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    showToast("User registered successfully!!")
                } else {
                    showToast("User registration failed!!")
                }
            }

    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

}