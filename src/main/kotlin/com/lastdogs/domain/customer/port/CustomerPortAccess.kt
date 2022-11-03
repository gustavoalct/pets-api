package com.lastdogs.domain.customer.port

import com.lastdogs.domain.customer.model.Customer
import java.util.UUID

interface CustomerPortAccess {
	fun create(customer: Customer): Customer
	fun getCustomerById(customerId: UUID): Customer

}