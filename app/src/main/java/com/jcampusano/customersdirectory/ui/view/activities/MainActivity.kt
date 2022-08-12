package com.jcampusano.customersdirectory.ui.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jcampusano.customersdirectory.databinding.ActivityMainBinding
import com.jcampusano.customersdirectory.ui.adapters.BusinessAdapter
import com.jcampusano.customersdirectory.ui.listeners.ClickListener
import com.jcampusano.customersdirectory.ui.viewModels.BusinessViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var viewManager = LinearLayoutManager(this)
    private lateinit var recyclerViewBusiness: RecyclerView
    private val businessViewModel: BusinessViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        businessViewModel.getBusiness()

        recyclerViewBusiness = binding.recyclerMain
        initializeAdapter()






        val fab = binding.addBusinessFab
        fab.setOnClickListener{
            val intent = Intent(this@MainActivity, CreateBusinessActivity::class.java)
            startActivity(intent)

        }

    }

    private fun initializeAdapter() {
        recyclerViewBusiness.layoutManager = viewManager
        observeAdapter()
    }

    private fun observeAdapter() {

        businessViewModel.businessModelList.observe(this){business ->
            recyclerViewBusiness.adapter = BusinessAdapter(business, object : ClickListener {
                override fun onClick(view: View, position: Int) {
                    val intent = Intent(this@MainActivity, CustomersListActivity::class.java)
                    val currentBusiness = business[position]
                    intent.putExtra("businessName", currentBusiness.name)
                    intent.putExtra("businessId", currentBusiness.id)
                    intent.putExtra("position", position)

                    startActivity(intent)
                }

                override fun onLongClick(v: View?, position: Int): Boolean {
                    return true
                }

            })
            recyclerViewBusiness.adapter?.notifyDataSetChanged()
        }
    }
}