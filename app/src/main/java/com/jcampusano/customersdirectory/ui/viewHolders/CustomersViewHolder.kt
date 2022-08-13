package com.jcampusano.customersdirectory.ui.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jcampusano.customersdirectory.R
import com.jcampusano.customersdirectory.ui.listeners.ClickListener



class CustomersViewHolder(itemView: View, listener: ClickListener): RecyclerView.ViewHolder(itemView), View.OnClickListener,
View.OnLongClickListener{
    private val clickListener = listener

    val customerName: TextView = itemView.findViewById(R.id.customerNameListTv)
    val customerRnc: TextView = itemView.findViewById(R.id.customerRncListTv)
    val customerPhone: TextView = itemView.findViewById(R.id.customerPhoneListTv)
    val addressRecyclerView: RecyclerView = itemView.findViewById(R.id.addressListRecycler)

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