package com.lastdogs.domain.authentication.port

import com.lastdogs.domain.authentication.model.Authentication
import com.lastdogs.domain.customer.model.Customer

interface AuthenticationPortAccess {
    fun login(accountLogin: Authentication): Customer?
}