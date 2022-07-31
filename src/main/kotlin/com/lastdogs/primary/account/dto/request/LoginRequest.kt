package com.lastdogs.primary.account.dto.request

import com.lastdogs.domain.account.model.AccountLogin

data class LoginRequest (
    val email:String,
    val password:String

){
    fun toModel() = AccountLogin(
        email = email,
        password = password
    )
}