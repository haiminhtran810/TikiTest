package com.hai.demo.base

import androidx.recyclerview.widget.DiffUtil

open class BaseDiffUtil<T : RecyclerViewItem> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return true
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

}