package com.lastdogs.primary.customer.dto.request

import com.lastdogs.domain.customer.model.Customer

data class CustomerRequest(

    val userName: String,
    val email: String,
    val password: String
) {
    fun toModel() = Customer(
        userName = userName,
        email = email,
        password = password
    )
}