package com.jcampusano.customersdirectory.ui.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jcampusano.customersdirectory.R



class BusinessViewHolder(itemView: View,  ): RecyclerView.ViewHolder(itemView){

    val businessName: TextView = itemView.findViewById(R.id.businessNameTv)
    val rnc:TextView = itemView.findViewById(R.id.businessRncTv)
    val phone:TextView = itemView.findViewById(R.id.businessRncTv)



}