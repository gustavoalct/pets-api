package com.lastdogs.domain.customer.service

import com.lastdogs.domain.customer.model.CustomerTest
import com.lastdogs.secundary.port.CustomerDataAccess
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc

class CustomerServiceTest {

	val customer = CustomerTest.build()
	val customerEmail = "gustavoTeste@gmail.com"

	val customerDataAccess: CustomerDataAccess = mockk {
		every { getCustomerByEmail(customerEmail) } returns customer
	}
	val customerService = CustomerService(customerDataAccess)

	@Test
	fun createOrUpdate() {
		// teste quebrando devido ao recursão no metodo salvar

		customerService.createOrUpdate(customer)
		// when
		verify(exactly = 1) { customerDataAccess.getCustomerByEmail(customerEmail) }
	}

}