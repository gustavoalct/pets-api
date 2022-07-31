package com.lastdogs.primary.account.dto.request

import com.lastdogs.domain.account.model.Customer

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