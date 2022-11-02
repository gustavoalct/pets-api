package com.lastdogs.domain.subscriptions.model

import java.util.UUID

object SubscriptionTest {

	fun build() = Subscription(
		id = UUID.randomUUID(),
		fullName = "Gustavo Gostosao"
	)

}