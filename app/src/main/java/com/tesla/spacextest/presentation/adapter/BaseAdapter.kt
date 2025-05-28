package com.tesla.spacextest.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class RocketLaunchesAdapter<T>(
    diffUtilCallback: DiffUtil.ItemCallback<T>,
    private val onItemClick: (T) -> Unit
) : ListAdapter<T, BaseViewHolder<T>>(diffUtilCallback) {
    private val items = mutableListOf<T>()

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            onItemClick(items[position])
        }
    }

    override fun getItemCount(): Int = items.size

    abstract fun update(newItems: List<T>)
}

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(listItem: T)
}