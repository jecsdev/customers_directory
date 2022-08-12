package com.jcampusano.customersdirectory.ui.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        recyclerViewCustomers = binding.recyclerCustomersList

        customersViewModel.business.postValue(businessId)
        initializeAdapter()



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
                    return true
                }

            })
        }
    }
}