package com.example.groceryapp.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryapp.R
import com.example.groceryapp.databinding.CategoryItemBinding
import com.example.groceryapp.model.remote.datamodel.category.CategoryData
import com.example.groceryapp.view.fragments.DashboardFragment

class CategoryAdapter(
    private val categoryList: List<CategoryData>,
    private val dashboardFragment: DashboardFragment
):
RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){
    private lateinit var categoryItemBinding: CategoryItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        categoryItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.category_item,parent, false)
        return CategoryViewHolder(categoryItemBinding)
    }
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.apply{
            val category = categoryList[position]
            bind(category)
            itemView.setOnClickListener {
                dashboardFragment.moveToSubCategories(category.catId, category.catName)
            }
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
    inner class CategoryViewHolder(private val binding: CategoryItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(category: CategoryData){
                binding.category = category
        }
    }
}