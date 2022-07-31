package com.lastdogs.secundary.port

import com.lastdogs.domain.account.model.AccountLogin
import com.lastdogs.domain.account.model.Customer

interface AccountDataAccess {

    fun createAccount(customer: Customer): Customer
    fun login(accountLogin: AccountLogin):Customer
}