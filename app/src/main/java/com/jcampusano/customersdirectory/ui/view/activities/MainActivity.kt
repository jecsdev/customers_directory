package com.jcampusano.customersdirectory.ui.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.jcampusano.customersdirectory.R
import com.jcampusano.customersdirectory.databinding.ActivityMainBinding
import com.jcampusano.customersdirectory.ui.view.fragments.CreateBusinessFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val createBusinessFragment = CreateBusinessFragment()

        val fab = binding.addBusinessFab
        fab.setOnClickListener{
            /*val intent = Intent(this@MainActivity, CreateBusinessActivity::class.java)
            startActivity(intent)*/
            supportFragmentManager.commit {
                setCustomAnimations(
                    androidx.appcompat.R.anim.abc_fade_in,
                    com.google.android.material.R.anim.abc_fade_out,
                )
                replace(R.id.mainContainer, createBusinessFragment)
                addToBackStack(null)
            }
        }

    }
}