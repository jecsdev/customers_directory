package com.jcampusano.customersdirectory.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jcampusano.customersdirectory.data.database.entities.BusinessEntity
import com.jcampusano.customersdirectory.data.database.entities.CustomersEntity
import java.util.*

@Dao
interface BusinessDao {
    //Businesss
    @Query("SELECT * FROM business ORDER by ID DESC")
    suspend fun getAllBusiness(): List<BusinessEntity>

    @Insert
    suspend fun insertBusiness(business: BusinessEntity)




    //Customers
    @Query("SELECT * FROM customers where :customerBusinessId = :businessId")
    suspend fun getBusinessCustomers(customerBusinessId: UUID, businessId: UUID): List<CustomersEntity>

    @Insert
    suspend fun insertCustomer(customer: CustomersEntity)

}