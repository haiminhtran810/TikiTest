package com.hai.demo.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<T : Any>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var item: T? = null

    open fun bind(item: T, position: Int) {
        this.item = item
    }
}