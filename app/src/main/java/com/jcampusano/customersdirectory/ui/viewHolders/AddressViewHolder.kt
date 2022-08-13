package com.jcampusano.customersdirectory.ui.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jcampusano.customersdirectory.R
import com.jcampusano.customersdirectory.ui.listeners.ClickListener

class AddressViewHolder(itemView: View, ): RecyclerView.ViewHolder(itemView){

    val address: TextView = itemView.findViewById(R.id.addressTv)

}