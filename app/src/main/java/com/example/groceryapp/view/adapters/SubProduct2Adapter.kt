package com.example.groceryapp.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryapp.R
import com.example.groceryapp.databinding.CategoryItemBinding
import com.example.groceryapp.databinding.ProductItemBinding
import com.example.groceryapp.model.remote.datamodel.product.ProductData
import com.example.groceryapp.viewmodel.GroceryViewModel

class SubProduct2Adapter(private val subProductList: List<ProductData>, private val viewModel: GroceryViewModel):
    RecyclerView.Adapter<SubProduct2Adapter.SubProduct2ViewHolder>(){
    private lateinit var subProductItemBinding: ProductItemBinding
    private lateinit var categoryItemBinding: CategoryItemBinding

    override fun getItemCount(): Int {
        return subProductList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubProduct2ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        subProductItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.product_item, parent, false
        )
        return SubProduct2ViewHolder(subProductItemBinding)

    }

    override fun onBindViewHolder(holder: SubProduct2ViewHolder, position: Int) {
        holder.bind(subProductList[position])
    }


    inner class SubProduct2ViewHolder(private val binding: ProductItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(productData: ProductData) {
            binding.product = productData
            binding.txtPrice.text = productData.price.toString()
        }
    }

}