package com.example.groceryapp.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryapp.R
import com.example.groceryapp.databinding.CategoryItemBinding
import com.example.groceryapp.databinding.ProductItemBinding
import com.example.groceryapp.model.remote.datamodel.product.ProductData
import com.example.groceryapp.viewmodel.GroceryViewModel

class SubProductAdapter(private val subProductList: List<ProductData>, private val viewModel: GroceryViewModel):
    RecyclerView.Adapter<SubProductAdapter.SubProductViewHolder>(){
    private lateinit var subProductItemBinding: ProductItemBinding

    override fun getItemCount(): Int {
        return subProductList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        subProductItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.product_item, parent, false
        )

        return SubProductViewHolder(subProductItemBinding)

    }

    override fun onBindViewHolder(holder: SubProductViewHolder, position: Int) {
          holder.bind(subProductList[position])
    }

    inner class SubProductViewHolder(private val binding: ProductItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(productData: ProductData) {
            binding.product = productData
            binding.txtPrice.text = productData.price.toString()
        }
    }

}