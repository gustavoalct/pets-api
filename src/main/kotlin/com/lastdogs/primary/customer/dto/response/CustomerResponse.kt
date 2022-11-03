package com.lastdogs.primary.customer.dto.response

import com.lastdogs.domain.customer.model.Customer
import java.util.UUID

data class CustomerResponse(
	val id: UUID,
	val userName: String?,
	val email: String?,
)

fun Customer.toResponse() = CustomerResponse(
	id = id!!,
	userName = userName,
	email = email
)
