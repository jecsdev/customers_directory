package com.jcampusano.customersdirectory.domain.model

import com.jcampusano.customersdirectory.data.database.entities.BusinessEntity

data class Business(
    var name: String,
    var rnc: String,
    var phone: String
)

fun BusinessEntity.toDomain() = Business(
    name = name,
    rnc = rnc,
    phone = phone
)