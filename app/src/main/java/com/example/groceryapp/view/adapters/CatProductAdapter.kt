package com.example.groceryapp.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryapp.R
import com.example.groceryapp.databinding.ProductItemBinding
import com.example.groceryapp.model.remote.datamodel.product.ProductData
import com.example.groceryapp.view.activities.SubCategoryActivity

class CatProductAdapter(private val catProductList: List<ProductData>, private val activity: SubCategoryActivity):
    RecyclerView.Adapter<CatProductAdapter.SubProductViewHolder>(){
    private lateinit var subProductItemBinding: ProductItemBinding

    override fun getItemCount(): Int {
        return catProductList.size
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
        val catProduct = catProductList[position]
        holder.bind(catProduct)
    }

    inner class SubProductViewHolder(private val binding: ProductItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(productData: ProductData) {
            binding.product = productData
            binding.tvPriceProduct.text = "$${productData.price}"
        }
        init {
            binding.apply{
                btnAddProduct.setOnClickListener {
                    activity.addItemToCart(product)
                    Toast.makeText(it.context,"${product?.productName} is added to cart",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}