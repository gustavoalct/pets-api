package com.lastdogs.domain.subscriptions.usecase

import com.lastdogs.domain.subscriptions.model.SubscriptionTest
import com.lastdogs.secundary.port.SubscriptionDataAccess
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import java.util.Optional
import java.util.UUID

class SubscriptionUseCaseTest {
	@Autowired
	lateinit var mockMvc: MockMvc
	val subscriptions = listOf(SubscriptionTest.build())  // Olhar classe, pois aqui já estabelece os valores esperados
	val subscriptionById = SubscriptionTest.build()
	val subscriptionId = UUID.fromString("6b70f410-87e6-46bf-a7b9-c5d0800a1949")

	// classe que passa no paramentro do useCase,
	// val subscriptionDataAccess: SubscriptionDataAccess = mockk() // Exemplo padrão
	// val paginacao:Pageable = mockk() // exemplo de mock na paginaçaõ

	final val subscriptionDataAccess: SubscriptionDataAccess =
		mockk { // aqui eu posso simular saidas de acordo com o teste
			every { getAll() } returns subscriptions   // every recurso do mockk, toda vez que for acontecer algo no metodo faz assim entrega assim
			every { getSubscriptionById(subscriptionId) } returns subscriptionById
		}

	val subscriptionUseCase =
		SubscriptionUseCase(subscriptionDataAccess)  // camada que queremos testar , precisamos passar o paramentro mockado

	@Test
	fun `Must getting all subscriptions`() {
		// Given
		subscriptionUseCase.getAllSubscriptions()

		// when
		verify(exactly = 1) { subscriptionDataAccess.getAll() }  // verifica se o metodo do getALl foi chamado uma vez
		verify(exactly = 0) { subscriptionDataAccess.getSubscriptionById(subscriptionId) }

		// then
		val results = subscriptionUseCase.getAllSubscriptions()
		assertNotNull(results)
		for (result in results) {
			assertTrue(result.fullName.isNotEmpty())
			assertFalse(result.id!!.equals(null))
		}

	}

	@Test
	fun `Must get subscription by id`() {
		subscriptionUseCase.getSubscriptionById(subscriptionId)
		verify(exactly = 1) { subscriptionDataAccess.getSubscriptionById(subscriptionId) }
	}

	@Test
	fun `Must response Exception getSubscriptionById not found`(){   // deve ser testado os casos que ñao de certo
			assertEquals(2,2)
//		every { subscriptionDataAccess.getSubscriptionById(any()) } returns Optional.empty()

//		val response = assertThrows<>()


	}

}
