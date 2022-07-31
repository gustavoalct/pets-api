package com.lastdogs.secundary.adapter

import com.lastdogs.domain.account.model.AccountLogin
import com.lastdogs.domain.account.model.Customer
import com.lastdogs.secundary.dbo.toDBO
import com.lastdogs.secundary.port.AccountDataAccess
import com.lastdogs.secundary.repository.CustomerRepository
import org.springframework.stereotype.Component

@Component
class AccountAdapter(
    val customerRepository: CustomerRepository
) : AccountDataAccess {

    override fun createAccount(customer: Customer): Customer {
        return customerRepository.save(customer.toDBO()).toModel()
    }

    override fun login(accountLogin: AccountLogin): Customer {
        return customerRepository.findByEmailAndPassword(
            accountLogin.email,
            accountLogin.password
        ).toModel()
    }

}