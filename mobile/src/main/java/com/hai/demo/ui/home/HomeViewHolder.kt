package com.hai.demo.ui.home

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.hai.demo.R
import com.hai.demo.base.BaseViewHolder


class HomeViewHolder(itemView: View) : BaseViewHolder<String>(itemView) {
    private val tvKeyword = itemView.findViewById<View>(R.id.tv_keyword) as TextView
    private val lgBackground = itemView.findViewById<View>(R.id.lg_background) as CardView

    override fun bind(item: String, position: Int) {
        super.bind(item, position)
        tvKeyword.text = item.trim()
        lgBackground.setCardBackgroundColor(itemView.resources.getIntArray(R.array.backgroundColor)[position%4])
    }
}

