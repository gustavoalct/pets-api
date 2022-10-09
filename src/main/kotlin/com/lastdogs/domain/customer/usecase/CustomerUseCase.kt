package com.lastdogs.domain.customer.usecase

import com.lastdogs.domain.customer.model.Customer
import com.lastdogs.domain.customer.port.CustomerPortAccess
import com.lastdogs.domain.customer.service.CustomerService
import org.springframework.stereotype.Component


@Component
class CustomerUseCase(
    val customerService: CustomerService
) : CustomerPortAccess {
    override fun create(customer: Customer): Customer {
        return customerService.create(customer)
    }

}