package com.lastdogs.domain.customer.service

import com.lastdogs.domain.customer.model.Customer
import com.lastdogs.secundary.port.CustomerDataAccess
import org.springframework.stereotype.Service


@Service
class CustomerService (
    val accountDataAccess: CustomerDataAccess
){

    fun create(customer: Customer):Customer{
       accountDataAccess.getCustomerByEmail(customer.email).let {
            if(it?.email.equals(null))
                return saveCustomer(customer)
            else
                return customer
        }
    }

    private fun saveCustomer(customer: Customer):Customer{
        return accountDataAccess.createAccount(customer = customer)
    }



}