package com.lastdogs.secundary.port

import com.lastdogs.domain.authentication.model.Authentication
import com.lastdogs.domain.customer.model.Customer

interface CustomerDataAccess {

    fun createAccount(customer: Customer): Customer
    fun login(accountLogin: Authentication):Customer?
    fun getCustomerByEmail(email:String):Customer?
}