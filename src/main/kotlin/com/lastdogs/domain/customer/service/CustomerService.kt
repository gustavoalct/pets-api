package com.lastdogs.domain.customer.service

import com.lastdogs.domain.customer.model.Customer
import com.lastdogs.secundary.port.CustomerDataAccess
import org.springframework.stereotype.Service


@Service
class CustomerService(
	val customerDataAccess: CustomerDataAccess
) {

	fun createOrUpdate(customer: Customer):Customer {
		customerDataAccess.getCustomerByEmail(customer.email!!).let {
			if (it?.email.isNullOrBlank())
				return saveCustomer(customer)
			else
				return saveCustomer(customer.toUpdate(customer))
		}
//		return customer
	}

	private fun saveCustomer(customer: Customer): Customer {
		return customerDataAccess.createAccount(customer = customer)
	}

}