package com.jcampusano.customersdirectory.domain.model

import com.jcampusano.customersdirectory.data.database.entities.CustomersEntity

data class Customer(
    var id: Int,
    var name: String,
    var phone: String,
    var rnc: String,
    var businessId: Int,
    var address: Map<String, String>? = null
)
fun CustomersEntity.toDomain() = Customer(
    id = id,
    name = name,
    phone = phone,
    rnc = rnc,
    businessId = businessId,
    address = address
)