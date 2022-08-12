package com.jcampusano.customersdirectory.domain.model

import com.jcampusano.customersdirectory.data.database.entities.BusinessEntity

data class Business(
    var id: Int,
    var name: String,
    var rnc: String,
    var phone: String
)

fun BusinessEntity.toDomain() = Business(
    id = id,
    name = name,
    rnc = rnc,
    phone = phone
)