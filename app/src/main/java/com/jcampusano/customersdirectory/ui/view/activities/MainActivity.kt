package com.jcampusano.customersdirectory.ui.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jcampusano.customersdirectory.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        val fab = binding.addBusinessFab
        fab.setOnClickListener{
            val intent = Intent(this@MainActivity, CreateBusinessActivity::class.java)
            startActivity(intent)

        }

    }
}