package com.lastdogs.secundary.adapter

import com.lastdogs.domain.authentication.model.Authentication
import com.lastdogs.domain.customer.model.Customer
import com.lastdogs.secundary.dbo.toDBO
import com.lastdogs.secundary.port.CustomerDataAccess
import com.lastdogs.secundary.repository.CustomerRepository
import org.springframework.stereotype.Component

@Component
class CustomerAdapter(
    val customerRepository: CustomerRepository
) : CustomerDataAccess {

    override fun createAccount(customer: Customer): Customer {
        return customerRepository.save(customer.toDBO()).toModel()
    }

    override fun login(accountLogin: Authentication): Customer? {
        return customerRepository.findByEmailAndPassword(
            accountLogin.email,
            accountLogin.password
        )?.toModel()
    }

    override fun getCustomerByEmail(email: String): Customer? {
        return customerRepository.findByEmail(email)?.toModel()
    }

}