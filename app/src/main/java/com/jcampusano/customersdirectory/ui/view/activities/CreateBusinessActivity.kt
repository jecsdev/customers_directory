package com.jcampusano.customersdirectory.ui.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jcampusano.customersdirectory.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateBusinessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_business)
        title = "Crear nueva empresa"
    }
}