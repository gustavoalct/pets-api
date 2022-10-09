package com.lastdogs.domain.authentication.usecase

import com.lastdogs.domain.authentication.model.Authentication
import com.lastdogs.domain.authentication.port.AuthenticationPortAccess
import com.lastdogs.domain.authentication.service.AuthenticationService
import com.lastdogs.domain.customer.model.Customer
import org.springframework.stereotype.Component

@Component
class AuthenticationUseCase(
    private val authenticationService: AuthenticationService
) : AuthenticationPortAccess {

    override fun login(accountLogin: Authentication): Customer? {
        return authenticationService.login(accountLogin)
    }

}