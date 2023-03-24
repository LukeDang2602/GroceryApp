package com.example.groceryapp.view.fragments.subcategories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.groceryapp.R
import com.example.groceryapp.databinding.FragmentChickenSubProductBinding
import com.example.groceryapp.model.remote.datamodel.subcategories.SubCategoryData
import com.example.groceryapp.view.adapters.SubProductAdapter
import com.example.groceryapp.viewmodel.GroceryViewModel
import com.example.groceryapp.viewmodel.createFactory


class ChickenSubProductFragment(private val subCategoryDataList: List<SubCategoryData>) : Fragment() {
    private lateinit var binding: FragmentChickenSubProductBinding
    private lateinit var viewModel: GroceryViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_chicken_sub_product,
            container,
            false
        )
        setUpRecyclerViewLayout()
        initViewModel()
        fetchSubProducts()
        initView()
        return binding.root
    }

    private fun initView() {
        binding.apply{
            subcategory1 = subCategoryDataList[0]
            subcategory2 = subCategoryDataList[1]
            subcategory3 = subCategoryDataList[2]
        }
    }

    private fun setUpRecyclerViewLayout() {
        binding.rv1.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        binding.rv2.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        binding.rv3.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
    }

    private fun fetchSubProducts() {
        for(data in subCategoryDataList) {
            viewModel.getSubProducts(data.subId)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserver()
    }

    private fun setUpObserver() {
        viewModel.subProducts.observe(viewLifecycleOwner) {
            val subId = it.last().subId

            if(subId== 1) {
                binding.rv1.adapter = SubProductAdapter(it, viewModel)
            }else if(subId == 2){
                binding.rv2.adapter = SubProductAdapter(it,viewModel)
            }else if(subId == 3){
                binding.rv3.adapter = SubProductAdapter(it,viewModel)
            }
        }
    }

    private fun initViewModel() {
        val factory = GroceryViewModel(requireActivity().application).createFactory()
        viewModel = ViewModelProvider(this,factory)[GroceryViewModel::class.java]
    }
}