package com.jcampusano.customersdirectory.ui.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jcampusano.customersdirectory.R
import com.jcampusano.customersdirectory.ui.listeners.ClickListener


class BusinessViewHolder(itemView: View, listener: ClickListener): RecyclerView.ViewHolder(itemView),
    View.OnClickListener,
    View.OnLongClickListener{

    val businessName: TextView = itemView.findViewById(R.id.businessNameTv)
    val rnc:TextView = itemView.findViewById(R.id.businessRncTv)
    val phone:TextView = itemView.findViewById(R.id.businessPhoneTv)


    private val clickListener = listener

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