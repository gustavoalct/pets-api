package com.lastdogs.primary.customer.dto.response

import com.lastdogs.domain.customer.model.Customer
import java.util.*

data class CreateAccountResponse(

    val id: UUID,
    val email:String
)

fun Customer.toResponse() = CreateAccountResponse(
    id = id!!,
    email = email
)