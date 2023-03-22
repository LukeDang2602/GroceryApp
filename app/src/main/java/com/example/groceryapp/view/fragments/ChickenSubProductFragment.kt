package com.example.groceryapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.groceryapp.databinding.FragmentChickenSubProductBinding
import com.example.groceryapp.model.remote.datamodel.product.ProductData
import com.example.groceryapp.model.remote.datamodel.subcategories.SubCategoryData
import com.example.groceryapp.view.adapters.SubProduct2Adapter
import com.example.groceryapp.view.adapters.SubProductAdapter
import com.example.groceryapp.viewmodel.GroceryViewModel
import com.example.groceryapp.viewmodel.createFactory


class ChickenSubProductFragment(private val subCategoryDataList: List<SubCategoryData>) : Fragment() {
    private lateinit var binding: FragmentChickenSubProductBinding
    private lateinit var viewModel: GroceryViewModel
    private var chickenItemsLists = ArrayList<List<List<ProductData>>>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChickenSubProductBinding.inflate(inflater, container, false)
        setUpRecyclerViewLayout()
        initViewModel()
        fetchSubProducts()
        return binding.root
    }
    private fun setUpRecyclerViewLayout() {
        binding.rv1.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        binding.rv2.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        binding.rv3.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
    }

    private fun fetchSubProducts() {
        subCategoryDataList.forEach {
            val subCatId = it.subId
            viewModel.getSubProducts(subCatId)
            setUpObserver(subCatId)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setUpObserver(subCatId: Int) {
        viewModel.subProducts.observe(viewLifecycleOwner) {
            if(subCatId == 1) {
                binding.rv1.adapter = SubProductAdapter(it, viewModel)
            }else if(subCatId == 2){
                binding.rv2.adapter = SubProduct2Adapter(it,viewModel)
            }else if(subCatId == 3){
                binding.rv3.adapter = SubProductAdapter(it,viewModel)
            }

            /*when(currentSubId){
                1 -> {
                    binding.rv1.adapter = SubProductAdapter(it,viewModel)
                }
                2 -> {
                    binding.rv2.adapter = SubProductAdapter(it,viewModel)
                }
                3 -> {
                    binding.rv3.adapter = SubProductAdapter(it,viewModel)
                }
            }*/
        }
    }

    private fun initViewModel() {
        val factory = GroceryViewModel(requireActivity().application).createFactory()
        viewModel = ViewModelProvider(this,factory)[GroceryViewModel::class.java]
    }
}