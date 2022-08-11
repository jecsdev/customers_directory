package com.jcampusano.customersdirectory.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jcampusano.customersdirectory.R
import com.jcampusano.customersdirectory.domain.model.Business
import com.jcampusano.customersdirectory.ui.viewHolders.BusinessViewHolder

class BusinessAdapter(private val businessList: MutableList<Business> ): RecyclerView.Adapter<BusinessViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(
            R.layout.business_list,
            parent, false
        )
        return BusinessViewHolder(layout)
    }

    override fun onBindViewHolder(holder: BusinessViewHolder, position: Int) {
        val business = businessList[position]

        holder.businessName.text = business.name
        holder.rnc.text = business.rnc
        holder.phone.text = business.phone

    }

    override fun getItemCount(): Int = businessList.size
}