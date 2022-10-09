package com.lastdogs.primary.customer.dto.request

import com.lastdogs.domain.authentication.model.Authentication

data class LoginRequest (
    val email:String,
    val password:String

){
    fun toModel() = Authentication(
        email = email,
        password = password
    )
}