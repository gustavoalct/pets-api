package com.lastdogs.primary.customer

import com.lastdogs.domain.customer.port.CustomerPortAccess
import com.lastdogs.primary.customer.dto.request.CustomerRequest
import com.lastdogs.primary.customer.dto.response.CustomerResponse
import com.lastdogs.primary.customer.dto.response.toResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/customers")
class CustomerController(
	private val customerPortAccess: CustomerPortAccess
) {

	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	fun create(@RequestBody customerRequest: CustomerRequest) {
		customerPortAccess.create(customerRequest.toModel())
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	fun getCustomerById(@RequestHeader customerId: UUID): CustomerResponse =
		customerPortAccess.getCustomerById(customerId).toResponse()

}