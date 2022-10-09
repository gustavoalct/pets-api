package com.lastdogs.domain.customer.port

import com.lastdogs.domain.customer.model.Customer

interface CustomerPortAccess {
    fun create(customer: Customer):Customer


}