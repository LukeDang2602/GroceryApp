package com.example.groceryapp.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.groceryapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseUser: FirebaseUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFirebase()
        initView()
    }
    private fun initFirebase() {
        firebaseAuth = FirebaseAuth.getInstance()
        if (firebaseAuth.currentUser != null) {
            firebaseUser = firebaseAuth.currentUser!!
        }
    }

    private fun initView() {
        binding.apply{
            btnSignIn.setOnClickListener{
                when {
                    etEmailLogin.text.isEmpty() -> {
                        etEmailLogin.error = null
                        etEmailLogin.requestFocus()
                        showToast("Email is empty")
                    }
                    etPassLogin.text.isEmpty() -> {
                        etPassLogin.error = null
                        etPassLogin.requestFocus()
                        showToast("Password is empty")
                    }
                    else -> {
                        firebaseAuth.signInWithEmailAndPassword(etEmailLogin.text.toString(), etPassLogin.text.toString())
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    startActivity(Intent(applicationContext, MainActivity::class.java))
                                    showToast("User logged in successfully!!")
                                } else {
                                    showToast("User credential failed!!")
                                }
                            }
                    }
                }
            }
            signUp.setOnClickListener {
                startActivity(Intent(applicationContext, RegistrationActivity::class.java))
            }
        }
    }

    private fun showToast(s: String) {
        Toast.makeText(this@LoginActivity, s, Toast.LENGTH_SHORT).show()
    }
}