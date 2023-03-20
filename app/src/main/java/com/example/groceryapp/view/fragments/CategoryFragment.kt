package com.example.groceryapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.groceryapp.databinding.FragmentCategoryBinding
import com.example.groceryapp.model.remote.datamodel.category.CategoryData
import com.example.groceryapp.view.adapters.CategoryAdapter
import com.example.groceryapp.viewmodel.GroceryViewModel
import com.example.groceryapp.viewmodel.createFactory

class CategoryFragment : Fragment() {
    private lateinit var binding: FragmentCategoryBinding
    private lateinit var viewModel: GroceryViewModel
    private var list: ArrayList<CategoryData> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initViewModel()
        binding = FragmentCategoryBinding.inflate(inflater,container, false)
        binding.rvCategories.layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
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
            binding.rvCategories.adapter = CategoryAdapter(it)
        }
    }


}