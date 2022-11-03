package com.lastdogs.domain.customer.usecase

import com.lastdogs.domain.customer.model.Customer
import com.lastdogs.domain.customer.port.CustomerPortAccess
import com.lastdogs.domain.customer.service.CustomerService
import com.lastdogs.exception.ErrorMessage
import com.lastdogs.exception.ErrorType
import com.lastdogs.primary.exception.LastDogsExceptions
import com.lastdogs.secundary.port.CustomerDataAccess
import org.springframework.stereotype.Component
import java.util.*


@Component
class CustomerUseCase(
	val customerService: CustomerService,
	val customerDataAccess: CustomerDataAccess
) : CustomerPortAccess {
	override fun create(customer: Customer): Customer {
		return customerService.createOrUpdate(customer)
	}

	override fun getCustomerById(customerId: UUID): Customer =
		customerDataAccess.getCustomerById(customerId) ?: throw LastDogsExceptions(
			message = ErrorMessage.CUSTOMER_NOT_FOUND.message,
			detailMessage = "CustomerId $customerId Not found",
			ErrorType.NOT_FOUND
		)


}