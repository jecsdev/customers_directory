package com.jcampusano.customersdirectory.domain

import com.jcampusano.customersdirectory.data.database.entities.BusinessEntity
import com.jcampusano.customersdirectory.data.repositories.BusinessRepository
import com.jcampusano.customersdirectory.domain.model.Business
import javax.inject.Inject

class BusinessUseCases @Inject constructor(private val businessRepository: BusinessRepository) {
    suspend operator fun invoke(): List<Business>{
        return businessRepository.getAllBusinessFromDatabase()
    }

    suspend fun insertBusiness(business: BusinessEntity){
        return businessRepository.insertBusiness(business)
    }
}