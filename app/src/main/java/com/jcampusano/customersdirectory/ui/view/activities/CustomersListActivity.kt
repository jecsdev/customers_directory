package com.jcampusano.customersdirectory.ui.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jcampusano.customersdirectory.databinding.ActivityCustomerslistBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomersListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomerslistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCustomerslistBinding.inflate(layoutInflater)
        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)
        val bundle = intent.extras

        title = bundle?.getString("businessName")
        val businessId = bundle?.getInt("businessId")

        val fab = binding.AddCustomersFab

        fab.setOnClickListener{
            val intent = Intent(this@CustomersListActivity, CreateCustomersActivity::class.java)
            intent.putExtra("businessId", businessId)
            startActivity(intent)
        }

    }
}