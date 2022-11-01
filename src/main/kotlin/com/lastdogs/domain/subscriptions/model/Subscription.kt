package com.lastdogs.domain.subscriptions.model

import java.util.UUID

data class Subscription(
	val id: UUID? = UUID.randomUUID(),
	val fullName: String
) {
	fun toUpdate(subscriptionRequest: Subscription) = this.copy(
		fullName = subscriptionRequest.fullName
	)
}
