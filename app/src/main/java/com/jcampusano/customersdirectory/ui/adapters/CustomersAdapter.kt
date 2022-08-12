package com.jcampusano.customersdirectory.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jcampusano.customersdirectory.R
import com.jcampusano.customersdirectory.domain.model.Customer
import com.jcampusano.customersdirectory.ui.listeners.ClickListener
import com.jcampusano.customersdirectory.ui.viewHolders.CustomersViewHolder

class CustomersAdapter(private val customerList: MutableList<Customer>, private val clickListener:ClickListener): RecyclerView.Adapter<CustomersViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomersViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(
            R.layout.customer_list,
            parent, false
        )
        return CustomersViewHolder(layout, clickListener)
    }

    override fun onBindViewHolder(holder: CustomersViewHolder, position: Int) {
       val customer = customerList[position]
        holder.customerName.text = customer.name
        holder.customerRnc.text = customer.rnc
        holder.customerPhone.text = customer.phone
        customer.address?.forEach {
            holder.customerAddress.text = it.value
        }

    }

    override fun getItemCount(): Int = customerList.size

}