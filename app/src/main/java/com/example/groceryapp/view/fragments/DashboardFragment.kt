package com.example.groceryapp.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.groceryapp.databinding.FragmentDashboardBinding
import com.example.groceryapp.utils.Constants.CATEGORY_ID
import com.example.groceryapp.utils.Constants.CATEGORY_NAME
import com.example.groceryapp.view.activities.MainActivity
import com.example.groceryapp.view.activities.SubCategoryActivity
import com.example.groceryapp.view.adapters.CategoryAdapter
import com.example.groceryapp.viewmodel.GroceryViewModel
import com.example.groceryapp.viewmodel.createFactory

class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding
    private lateinit var viewModel: GroceryViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initViewModel()
        binding = FragmentDashboardBinding.inflate(inflater,container, false)
        binding.rvCategories.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserver()
        viewModel.getCategories()
    }

    private fun initViewModel() {
        val factory = GroceryViewModel(requireActivity().application).createFactory()
        viewModel = ViewModelProvider(this,factory)[GroceryViewModel::class.java]
    }
    private fun setUpObserver() {
        viewModel.categories.observe(viewLifecycleOwner){
            if(it == null) return@observe

            binding.rvCategories.adapter = CategoryAdapter(it,this@DashboardFragment)
        }
    }

    fun moveToSubCategories(catId: Int, catName: String) {
        (activity as MainActivity).moveToSubCategoryActivity(catId, catName)
    }
}