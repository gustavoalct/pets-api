package com.lastdogs.domain.subscriptions.usecase

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
@AutoConfigureMockMvc
class SubscriptionUseCaseTest {

	@Autowired
	lateinit var autowired: Autowired

	@Test
	fun `get all subscription use case`() {

	}
}