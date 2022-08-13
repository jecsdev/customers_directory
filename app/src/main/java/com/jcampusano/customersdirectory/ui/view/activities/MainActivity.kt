package com.jcampusano.customersdirectory.ui.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jcampusano.customersdirectory.data.database.entities.BusinessEntity
import com.jcampusano.customersdirectory.data.database.entities.CustomerEntity
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
        val businessName = binding.businessLabel

        businessViewModel.businessModelList.observe(this) {
            if (it.isEmpty()) {
                businessName.visibility = View.GONE
            }
        }


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
                    val builder = AlertDialog.Builder(this@MainActivity)
                    builder.setTitle("Borrar")
                    builder.setMessage("Esta seguro de querer borrar este elemento?")
                    builder.setPositiveButton("Si") { _, _ ->

                        val businessName = business[position].name
                        val businessRnc = business[position].rnc
                        val businessPhone = business[position].phone
                        val businessId = business[position].id
                        val businessData = BusinessEntity(
                            id = businessId, name = businessName, rnc = businessRnc,
                            phone = businessPhone
                        )
                        businessViewModel.deleteBusiness(businessData)

                    }
                    builder.setNegativeButton("Cancelar", null).show()
                    return true
                }

            })

        }

    }

    override fun onResume() {

        super.onResume()
        initializeAdapter()
    }

    override fun onRestart() {

        super.onRestart()
        initializeAdapter()
    }
}