package com.lastdogs.secundary.adapter

import com.lastdogs.domain.subscriptions.model.Subscription
import com.lastdogs.secundary.dbo.toDBO
import com.lastdogs.secundary.port.SubscriptionDataAccess
import com.lastdogs.secundary.repository.SubscriptionRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class SubscriptionAdapter(
	private val subscriptionRepository: SubscriptionRepository
):SubscriptionDataAccess {

	override fun save(subscription: Subscription) {
		subscriptionRepository.save(subscription.toDBO())
	}

	override fun getAll(): List<Subscription> {
		return subscriptionRepository.findAll().map { it.toModel() }
	}

	override fun subscriptionId(subscriptionId: UUID): Subscription? {
		return subscriptionRepository.getById(subscriptionId).toModel()
	}
}