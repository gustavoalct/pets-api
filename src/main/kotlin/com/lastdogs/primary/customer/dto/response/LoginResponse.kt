package com.lastdogs.primary.customer.dto.response

import com.lastdogs.domain.customer.model.Customer

data class LoginResponse(
    val name:String,
    val email: String,
)

fun Customer.toLoginResponse() = LoginResponse(
    name = userName,
    email = email!!
)