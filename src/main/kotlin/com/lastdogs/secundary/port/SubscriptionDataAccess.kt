package com.lastdogs.secundary.port

import com.lastdogs.domain.subscriptions.model.Subscription
import java.util.UUID

interface SubscriptionDataAccess {

	fun save(subscription: Subscription)
	fun getAll(): List<Subscription>
	fun subscriptionId(subscriptionId: UUID): Subscription?

}