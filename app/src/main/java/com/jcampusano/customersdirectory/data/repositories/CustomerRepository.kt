package com.jcampusano.customersdirectory.data.repositories

import com.jcampusano.customersdirectory.data.database.dao.CustomersDao
import com.jcampusano.customersdirectory.data.database.entities.CustomerEntity
import com.jcampusano.customersdirectory.domain.model.Customer
import com.jcampusano.customersdirectory.domain.model.toDomain
import javax.inject.Inject

class CustomerRepository @Inject constructor(private val customersDao: CustomersDao) {
     suspend fun getCustomersById(business: Int): List<Customer>? {
        val response: List<CustomerEntity>? = customersDao.getCustomersByBusinessId(business)
        return response?.map {it.toDomain()}
    }

    suspend fun insertCustomer(customer: CustomerEntity){
        customersDao.insertCustomer(customer)
    }

    suspend fun deleteCustomer(customer: CustomerEntity){
        customersDao.deleteCustomer(customer)
    }
}