package com.jcampusano.customersdirectory.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jcampusano.customersdirectory.data.database.entities.BusinessEntity

@Dao
interface BusinessDao {
    @Query("SELECT * FROM business ORDER by ID DESC")
    suspend fun getAllBusiness(): List<BusinessEntity>

    @Insert
    suspend fun insertBusiness(business: BusinessEntity)

    @Delete
    suspend fun deleteBusiness(business: BusinessEntity)

}