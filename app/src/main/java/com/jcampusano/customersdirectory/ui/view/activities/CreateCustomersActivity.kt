package com.jcampusano.customersdirectory.ui.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jcampusano.customersdirectory.data.database.entities.CustomerEntity
import com.jcampusano.customersdirectory.databinding.ActivityCreateCustomersBinding
import com.jcampusano.customersdirectory.ui.adapters.AddressAdapter
import com.jcampusano.customersdirectory.ui.listeners.ClickListener
import com.jcampusano.customersdirectory.ui.viewModels.CustomersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateCustomersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateCustomersBinding
    private val customersViewModel:CustomersViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCustomersBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        title = "Creación de cliente"
        val bundle = intent.extras
        val businessId = bundle?.getInt("businessId")
        val customerName = binding.customerNameTxt
        val customerRnc = binding.customerRnc
        val customerPhone = binding.customerPhone
        val customerAddress = binding.customerAddress
        val addButton = binding.addAddressBtn
        val fab = binding.saveCustomersFab
        val recyclerView = binding.addressRecyclerView
        val address = HashMap<Int, String>()
        var counter = 0



        addButton.setOnClickListener{
            if(customerAddress.text!!.isNotEmpty()){
                address[counter] = customerAddress.text.toString()
                customerAddress.text!!.clear()
                customersViewModel.addressLiveData.postValue(address)
                counter++
            }
        }

        customersViewModel.addressLiveData.observe(this){
            recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            recyclerView.adapter = AddressAdapter(it)

        }

        fab.setOnClickListener {
            if(TextUtils.isEmpty(customerName.text)){
                customerName.error = "Este campo no puede estar vacio."
            }
             if(TextUtils.isEmpty(customerRnc.text)){
                customerRnc.error = "Este campo no puede estar vacio."
            }
             if(TextUtils.isEmpty(customerPhone.text)){
                customerPhone.error = "Este campo no puede estar vacio."
            }
            if(address.isEmpty()){
                customerAddress.error = "Debe seleccionar al menos 1 dirección."
            }

            if(address.isNotEmpty()  && customerName.text!!.isNotEmpty()
                && customerRnc.text!!.isNotEmpty()  && customerPhone.text!!.isNotEmpty()) {
                val customer = businessId?.let { businessId ->
                    CustomerEntity(
                        name = customerName.text.toString(),
                        rnc = customerRnc.text.toString(),
                        phone = customerPhone.text.toString(), businessId = businessId,
                        address = address
                    )


                }
                if (customer != null) {
                    customersViewModel.addCustomer(customer)
                }
                finish()

            }


        }

    }
}