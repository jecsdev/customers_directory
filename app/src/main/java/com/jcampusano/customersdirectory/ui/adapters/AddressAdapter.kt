package com.jcampusano.customersdirectory.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jcampusano.customersdirectory.R
import com.jcampusano.customersdirectory.ui.listeners.ClickListener
import com.jcampusano.customersdirectory.ui.viewHolders.AddressViewHolder


class AddressAdapter(private val addressList: HashMap<Int, String>): RecyclerView.Adapter<AddressViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(
            R.layout.address_list,
            parent, false
        )
        return AddressViewHolder(layout)
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        val address = addressList[position]
        holder.address.text = address

    }

    override fun getItemCount(): Int = addressList.size

}