package com.lastdogs.domain.subscriptions.usecase

import com.lastdogs.domain.subscriptions.model.Subscription
import com.lastdogs.domain.subscriptions.port.SubscriptionPortAccess
import com.lastdogs.secundary.port.SubscriptionDataAccess
import org.springframework.stereotype.Component
import java.util.*

@Component
class SubscriptionUseCase(
	private val subscriptionDataAccess: SubscriptionDataAccess
) : SubscriptionPortAccess {

	override fun create(subscription: Subscription) {
		subscriptionDataAccess.save(subscription)
	}

	override fun getAllSubscriptions(): List<Subscription> {
		return subscriptionDataAccess.getAll()
	}

	override fun getSubscriptionById(subscriptionId: UUID): Subscription {
		return subscriptionDataAccess.getSubscriptionById(subscriptionId)
			?: throw Exception("Subscription Not found ${subscriptionId}")
	}

	override fun update(subscriptionId: UUID, subscriptionRequest: Subscription) {
		getSubscriptionById(subscriptionId).also {
			subscriptionDataAccess.save(it.toUpdate(subscriptionRequest))
		}
	}
}