package com.jcampusano.customersdirectory.ui.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jcampusano.customersdirectory.R
import com.jcampusano.customersdirectory.ui.listeners.ClickListener

class AddressViewHolder(itemView: View, listener: ClickListener): RecyclerView.ViewHolder(itemView), View.OnClickListener,
View.OnLongClickListener{
    private val clickListener = listener
    val address: TextView = itemView.findViewById(R.id.addressTv)
    init {
        itemView.setOnClickListener(this)
        itemView.setOnLongClickListener(this)
    }

    override fun onClick(v: View?) {
        this.clickListener.onClick(v!!, adapterPosition)
    }

    override fun onLongClick(v: View?): Boolean {
        return this.clickListener.onLongClick(v!!, adapterPosition)
    }
}