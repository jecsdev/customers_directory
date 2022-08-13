package com.jcampusano.customersdirectory.ui.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jcampusano.customersdirectory.data.database.entities.CustomerEntity
import com.jcampusano.customersdirectory.databinding.ActivityCustomerslistBinding
import com.jcampusano.customersdirectory.ui.adapters.CustomersAdapter
import com.jcampusano.customersdirectory.ui.listeners.ClickListener
import com.jcampusano.customersdirectory.ui.viewModels.CustomersViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class CustomersListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomerslistBinding
    private lateinit var recyclerViewCustomers: RecyclerView
    private var viewManager = LinearLayoutManager(this)
    private val customersViewModel:CustomersViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCustomerslistBinding.inflate(layoutInflater)
        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)
        val bundle = intent.extras

        title = bundle?.getString("businessName")


        val businessId = bundle?.getInt("businessId")
        businessId?.let { customersViewModel.getCustomers(businessId = it) }
        val fab = binding.AddCustomersFab
        val customerList = binding.CustomersLabel
        recyclerViewCustomers = binding.recyclerCustomersList

        customersViewModel.business.postValue(businessId)
        initializeAdapter()

        customersViewModel.customersModelList.observe(this){
            if(it.isNullOrEmpty()){
                customerList.visibility = View.GONE
            }
        }

        fab.setOnClickListener{
            val intent = Intent(this@CustomersListActivity, CreateCustomersActivity::class.java)
            intent.putExtra("businessId", businessId)
            startActivity(intent)
        }

    }

    private fun initializeAdapter() {
        recyclerViewCustomers.layoutManager = viewManager
        observeAdapter()
    }

    private fun observeAdapter() {
        customersViewModel.customersModelList.observe(this){
            recyclerViewCustomers.adapter = CustomersAdapter(it, object: ClickListener{
                override fun onClick(view: View, position: Int) {

                }

                override fun onLongClick(v: View?, position: Int): Boolean {
                    val builder = AlertDialog.Builder(this@CustomersListActivity)
                    builder.setTitle("Borrar")
                    builder.setMessage("Esta seguro de querer borrar este elemento?")
                    builder.setPositiveButton("Si") { _, _ ->

                        val customerName = it[position].name
                        val customerRnc = it[position].rnc
                        val customerPhone = it[position].phone
                        val businessId = it[position].businessId
                        val address = it[position].address
                        val id = it[position].id
                        val customer = CustomerEntity( id = id,name = customerName, rnc = customerRnc,
                        phone =  customerPhone, businessId = businessId, address = address)
                        customersViewModel.deleteCustomer(customer)
                    }
                    builder.setNegativeButton("Cancelar", null).show()


                    return true
                }

            })

        }
    }
}