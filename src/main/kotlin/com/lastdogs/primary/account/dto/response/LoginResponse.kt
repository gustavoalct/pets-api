package com.lastdogs.primary.account.dto.response

import com.lastdogs.domain.account.model.Customer

data class LoginResponse(
    val name:String,
    val email: String,
)

fun Customer.toLoginResponse() = LoginResponse(
    name = userName,
    email = email
)