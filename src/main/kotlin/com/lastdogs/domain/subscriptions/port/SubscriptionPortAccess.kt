package com.lastdogs.domain.subscriptions.port

import com.lastdogs.domain.subscriptions.model.Subscription
import java.util.UUID


interface SubscriptionPortAccess {

    fun getAllSubscriptions():List<Subscription>
    fun getSubscriptionById(subscriptionId: UUID):Subscription
    fun create(subscription: Subscription)
    fun update(subscriptionId: UUID, subscription: Subscription)
}