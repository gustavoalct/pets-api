package com.lastdogs.primary.subscription.dto.request

import com.lastdogs.domain.subscriptions.model.Subscription

data class SubscriptionRequest(
	val fullName: String
){
	fun toModel() = Subscription(
		fullName = fullName
	)
}