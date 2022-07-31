package com.lastdogs.primary.account.dto.response

import com.lastdogs.domain.account.model.Customer
import java.util.*

data class CreateAccountResponse(

    val id: UUID,
    val email:String
)

fun Customer.toResponse() = CreateAccountResponse(
    id = id!!,
    email = email
)