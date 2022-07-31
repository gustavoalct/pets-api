package com.lastdogs.domain.account.port

import com.lastdogs.domain.account.model.AccountLogin
import com.lastdogs.domain.account.model.Customer

interface AccountPortAccess {
    fun create(customer: Customer):Customer
    fun login(accountLogin: AccountLogin):Customer

}