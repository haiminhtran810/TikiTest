package com.hai.demo.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hai.demo.R
import com.hai.demo.base.BaseViewHolder

class HomeAdapter : ListAdapter<String, BaseViewHolder<String>>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<String> {
        return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_keyword, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<String>, position: Int) {
        holder.bind(getItem(position), position)
    }

    private object diffUtil : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return true
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
}