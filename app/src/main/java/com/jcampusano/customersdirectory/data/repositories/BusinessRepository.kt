package com.jcampusano.customersdirectory.data.repositories

import com.jcampusano.customersdirectory.data.database.dao.BusinessDao
import com.jcampusano.customersdirectory.data.database.entities.BusinessEntity
import com.jcampusano.customersdirectory.domain.model.Business
import com.jcampusano.customersdirectory.domain.model.toDomain
import javax.inject.Inject

class BusinessRepository @Inject constructor(private val businessDao: BusinessDao) {

    suspend fun getAllBusinessFromDatabase(): List<Business>{
        val response: List<BusinessEntity> = businessDao.getAllBusiness()
        return response.map {it.toDomain()}
    }


    suspend fun insertBusiness(business: BusinessEntity){
        businessDao.insertBusiness(business)
    }

    suspend fun deleteBusiness(business: BusinessEntity){
        businessDao.deleteBusiness(business)
    }
}