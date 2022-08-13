package com.jcampusano.customersdirectory.domain.UseCases


import com.jcampusano.customersdirectory.data.database.entities.CustomerEntity
import com.jcampusano.customersdirectory.data.repositories.CustomerRepository
import com.jcampusano.customersdirectory.domain.model.Customer
import javax.inject.Inject

class CustomersUseCases @Inject constructor(private val customersRepository: CustomerRepository) {
    suspend operator fun invoke(business: Int): List<Customer>? {
        return customersRepository.getCustomersById(business)
    }

    suspend fun insertCustomer(customer:CustomerEntity){
        customersRepository.insertCustomer(customer)
    }

    suspend fun deleteCustomer(customer: CustomerEntity){
        customersRepository.deleteCustomer(customer)
    }

}