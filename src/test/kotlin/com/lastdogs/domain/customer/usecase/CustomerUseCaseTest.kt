package com.lastdogs.domain.customer.usecase

import com.lastdogs.domain.customer.model.CustomerTest
import com.lastdogs.domain.customer.service.CustomerService
import com.lastdogs.secundary.port.CustomerDataAccess
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*

class CustomerUseCaseTest {
	val customerId = UUID.fromString("e88efb37-0136-4cab-b213-1ec6b30fe99f")
	val customer = CustomerTest.build()
	val customerService:CustomerService = mockk()
	val customerDataAccess:CustomerDataAccess = mockk{
		every { getCustomerById(customerId) } returns customer;
	}
	val customerUseCase = CustomerUseCase(customerService, customerDataAccess)

	@Test
	fun `Deve trazer o customer pelo seu id`() {
		customerUseCase.getCustomerById(customerId)
		verify (exactly = 1){ customerDataAccess.getCustomerById(customerId) }

		val result = customerUseCase.getCustomerById(customerId)
		assertNotNull(result)

	}
}