package com.lastdogs.domain.account.usecase

import com.lastdogs.domain.account.model.AccountLogin
import com.lastdogs.domain.account.model.Customer
import com.lastdogs.domain.account.port.AccountPortAccess
import com.lastdogs.secundary.port.AccountDataAccess
import org.springframework.stereotype.Component


@Component
class AccountUseCase(
    val accountDataAccess: AccountDataAccess
) : AccountPortAccess {
    override fun create(customer: Customer): Customer {
        return accountDataAccess.createAccount(customer)
    }

    override fun login(accountLogin: AccountLogin): Customer {
        return accountDataAccess.login(accountLogin)
    }
}