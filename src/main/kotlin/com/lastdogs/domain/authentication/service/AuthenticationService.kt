package com.lastdogs.domain.authentication.service

import com.lastdogs.domain.authentication.model.Authentication
import com.lastdogs.domain.customer.model.Customer
import com.lastdogs.secundary.port.CustomerDataAccess
import org.springframework.stereotype.Service


@Service
class AuthenticationService(
    private val customerDataAccess: CustomerDataAccess
) {
    fun login(customer: Authentication): Customer? {
        return customerDataAccess.login(customer)
    }

}