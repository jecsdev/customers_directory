package com.jcampusano.customersdirectory.data.database

import com.jcampusano.customersdirectory.data.database.TypeConverters.Converters
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jcampusano.customersdirectory.data.database.dao.BusinessDao
import com.jcampusano.customersdirectory.data.database.dao.CustomersDao
import com.jcampusano.customersdirectory.data.database.entities.BusinessEntity
import com.jcampusano.customersdirectory.data.database.entities.CustomerEntity

@Database(entities = [BusinessEntity::class, CustomerEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class BusinessDatabase: RoomDatabase() {
    abstract fun getBusinessDao(): BusinessDao
    abstract fun getCustomersDao(): CustomersDao
}