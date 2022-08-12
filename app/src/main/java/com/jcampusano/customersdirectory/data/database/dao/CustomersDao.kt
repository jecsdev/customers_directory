package com.jcampusano.customersdirectory.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jcampusano.customersdirectory.data.database.entities.CustomerEntity



@Dao
interface CustomersDao {
    @Query("SELECT * FROM customers where :customerBusinessId = businessId")
    suspend fun getCustomersByBusinessId(customerBusinessId: Int ): List<CustomerEntity>?

    @Insert
    suspend fun insertCustomer(customer: CustomerEntity)

    @Delete
    suspend fun deleteCustomer(customer: CustomerEntity)
}