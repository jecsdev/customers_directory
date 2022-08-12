package com.jcampusano.customersdirectory.ui.viewModels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcampusano.customersdirectory.data.database.dao.CustomersDao
import com.jcampusano.customersdirectory.data.database.entities.CustomersEntity
import com.jcampusano.customersdirectory.domain.model.Business

import com.jcampusano.customersdirectory.domain.model.Customer
import com.jcampusano.customersdirectory.domain.model.toDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CustomersViewModel @Inject constructor(private val customersDao: CustomersDao): ViewModel() {
    val customersModelList = MutableLiveData<MutableList<Customer>>()
    val business = MutableLiveData<Business>()



    fun getCustomers() {
        viewModelScope.launch {
            val list = business.value?.let { getCustomersById(it) }
            customersModelList.postValue(list as MutableList<Customer>)
        }
    }

    private suspend fun getCustomersById(business: Business): List<Customer>{
        val response: List<CustomersEntity> = customersDao.getCustomersByBusinessId(business.id)
        return response.map {it.toDomain()}
    }


}