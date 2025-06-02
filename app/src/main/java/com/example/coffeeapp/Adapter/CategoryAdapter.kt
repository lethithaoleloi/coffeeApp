package com.example.coffeeapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeapp.Domain.CategoryModel
import com.example.coffeeapp.R
import com.example.coffeeapp.databinding.ViewholderCategoryBinding
import android.content.Context

class CategoryAdapter(val items:MutableList<CategoryModel>)
    :RecyclerView.Adapter<CategoryAdapter.Viewholder>(){

        private lateinit var context: Context
        private var selectedPosition=-1
        private var lastSelectedPosition=-1
        inner class Viewholder(val binding: ViewholderCategoryBinding)
            :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.Viewholder {
        context=parent.context
        val binding=ViewholderCategoryBinding.inflate(LayoutInflater.from(context),parent,false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.Viewholder, position: Int) {
        val item=items[position]
        holder.binding.titleCart.text=item.title

        holder.binding.root.setOnClickListener {
            val currentPosition = holder.adapterPosition
            if (currentPosition == RecyclerView.NO_POSITION) return@setOnClickListener

            lastSelectedPosition = selectedPosition
            selectedPosition = currentPosition

            // Only notify if positions are valid
            if (lastSelectedPosition != -1) notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)
        }
        }

    override fun getItemCount(): Int =items.size
}