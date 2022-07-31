package com.lastdogs.domain.account.model

import java.util.UUID

data class Customer(

    val id: UUID? = UUID.randomUUID(),
    val userName: String,
    val email: String,
    val password: String,

    )
