package com.lastdogs.secundary.port

import com.lastdogs.domain.authentication.model.Authentication
import com.lastdogs.domain.customer.model.Customer
import java.util.UUID

interface CustomerDataAccess {

	fun createAccount(customer: Customer): Customer
	fun login(accountLogin: Authentication): Customer?
	fun getCustomerByEmail(email: String): Customer?
	fun getCustomerById(customerId: UUID): Customer?
}