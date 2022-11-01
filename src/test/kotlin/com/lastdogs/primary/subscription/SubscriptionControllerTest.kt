package com.lastdogs.primary.subscription

import com.fasterxml.jackson.databind.ObjectMapper
import com.lastdogs.primary.subscription.dto.request.SubscriptionRequest
import com.lastdogs.secundary.port.SubscriptionDataAccess
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
class SubscriptionControllerTest {

	@Autowired
	lateinit var mockMvc: MockMvc

	@Autowired
	lateinit var subscriptionDataAccess: SubscriptionDataAccess


	@Test
	fun `getting all subscription controller`() {
		mockMvc.perform(MockMvcRequestBuilders.get("/subscription"))  // testando diretamente na controller
			.andExpect(MockMvcResultMatchers.status().isOk)  // annExpect seria um assertEquals, verifica se o valor é o esperado
			.andExpect(MockMvcResultMatchers.jsonPath("\$").isArray)
			.andExpect(MockMvcResultMatchers.jsonPath("\$[0].id").isNotEmpty) //ia verificar se seria um UUID, mas não tem
			.andExpect(MockMvcResultMatchers.jsonPath("\$[1].fullName").isString)
			.andDo(MockMvcResultHandlers.print())
	}

	@Test
	fun `getting subscription by subscriptionId`() {
		val subscriptionId = UUID.fromString("17d29ec2-9041-4526-ba89-a4a60fab5caa")
		val subscription = subscriptionDataAccess.subscriptionId(subscriptionId = subscriptionId)

		mockMvc.perform(MockMvcRequestBuilders.get("/subscription/${subscriptionId}"))  // testando diretamente na controller
			.andExpect(MockMvcResultMatchers.status().isOk)  // annExpect seria um assertEquals, verifica se o valor é o esperado
			.andExpect(MockMvcResultMatchers.jsonPath("\$").isNotEmpty)
			.andExpect(MockMvcResultMatchers.jsonPath("\$.id").isNotEmpty) //ia verificar se seria um UUID, mas não tem//ia verificar se seria um UUID, mas não tem
			.andExpect(MockMvcResultMatchers.jsonPath("\$.fullName").value(subscription?.fullName))
			.andExpect(MockMvcResultMatchers.jsonPath("\$.fullName").isString)
			.andDo(MockMvcResultHandlers.print())
	}

	@Test
	fun `create subscription`() {
		val subscriptionRequest = SubscriptionRequest("JoãoZim")
		val json = ObjectMapper().writeValueAsString(subscriptionRequest)

		mockMvc.perform(MockMvcRequestBuilders.post("/subscription")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)
			.content(json)
		)
			.andExpect(MockMvcResultMatchers.status().isOk)  // annExpect seria um assertEquals, verifica se o valor é o esperado
			.andDo(MockMvcResultHandlers.print())

		assert(subscriptionDataAccess.getAll().isNotEmpty())
	}

	@Test
	fun `update subscription`(){
		val subscriptionRequest = SubscriptionRequest("LUANAaaaa")
		val json = ObjectMapper().writeValueAsString(subscriptionRequest)
		val subscriptionId = UUID.fromString("17d29ec2-9041-4526-ba89-a4a60fab5caa")

		mockMvc.perform(MockMvcRequestBuilders.patch("/subscription/${subscriptionId}")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)
			.content(json)
		)
			.andExpect(MockMvcResultMatchers.status().isOk)  // annExpect seria um assertEquals, verifica se o valor é o esperado
			.andDo(MockMvcResultHandlers.print())
		assertTrue(subscriptionDataAccess.subscriptionId(subscriptionId)?.fullName!!.isNotEmpty(), "Subscription is present")
		assertEquals(subscriptionDataAccess.subscriptionId(subscriptionId)?.fullName, subscriptionRequest.fullName)
	}

}

