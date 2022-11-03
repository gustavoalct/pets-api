package com.lastdogs.domain.customer.model

import java.util.UUID

data class Customer(
	val id: UUID? = UUID.randomUUID(),
	val userName: String,
	val email: String? = null,
	val password: String
) {
	fun toUpdate(customerUpdateRequest: Customer) = this.copy(
		userName = customerUpdateRequest.userName,
		email = customerUpdateRequest.email?: email,
		password = password
	)
}
