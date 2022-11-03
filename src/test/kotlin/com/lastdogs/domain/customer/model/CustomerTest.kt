package com.lastdogs.domain.customer.model

import java.util.UUID

object CustomerTest {

	fun build() = Customer(
		id = UUID.randomUUID(),
		userName = "Gustavo teste",
		email = "gustavoTeste@gmail.com",
		password = "123456"
	)
}