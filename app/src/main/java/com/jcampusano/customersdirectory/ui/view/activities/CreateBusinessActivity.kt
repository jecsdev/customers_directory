package com.jcampusano.customersdirectory.ui.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.activity.viewModels
import com.jcampusano.customersdirectory.R
import com.jcampusano.customersdirectory.data.database.entities.BusinessEntity
import com.jcampusano.customersdirectory.databinding.ActivityCreateBusinessBinding
import com.jcampusano.customersdirectory.ui.viewModels.BusinessViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateBusinessActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCreateBusinessBinding
    private val businessViewModel: BusinessViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateBusinessBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        title = "Crear nueva empresa"

        val businessName = binding.addBusinessName
        val businessRnc = binding.addBusinessRnc
        val businessPhone = binding.addBusinessPhone

        val saveFab = binding.saveBusinessFab

        saveFab.setOnClickListener{
            if(TextUtils.isEmpty(businessName.text)){
                businessName.error = "Este campo no puede estar vacio."
            }
            if(TextUtils.isEmpty(businessRnc.text)){
                businessRnc.error = "Este campo no puede estar vacio."
            }
            if(TextUtils.isEmpty(businessPhone.text)){
                businessPhone.error = "Este campo no puede estar vacio."
            }


            val business = BusinessEntity(name = businessName.text.toString(),
            rnc = businessRnc.text.toString(),
            phone = businessPhone.text.toString())


            businessViewModel.createBusiness(business)
            finish()

        }

    }
}