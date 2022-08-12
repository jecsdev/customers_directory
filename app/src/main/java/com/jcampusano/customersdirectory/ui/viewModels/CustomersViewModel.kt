package com.jcampusano.customersdirectory.ui.viewModels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcampusano.customersdirectory.data.database.entities.CustomerEntity
import com.jcampusano.customersdirectory.domain.UseCases.CustomersUseCases

import com.jcampusano.customersdirectory.domain.model.Customer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CustomersViewModel @Inject constructor(private val customersUseCases: CustomersUseCases): ViewModel() {
    val customersModelList = MutableLiveData<MutableList<Customer>>()
    val business = MutableLiveData<Int>()
    val addressLiveData = MutableLiveData<HashMap<Int, String>>()



    fun getCustomers(businessId: Int) {
        viewModelScope.launch {
            val list = customersUseCases.invoke(businessId)
            customersModelList.postValue(list as MutableList<Customer>?)
        }
    }



    fun addCustomer(customer: CustomerEntity){
        viewModelScope.launch {
            customersUseCases.insertCustomer(customer)
        }
    }


}