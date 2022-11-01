package com.lastdogs.domain.subscriptions.port

import com.lastdogs.domain.subscriptions.model.Subscription
import java.util.*


interface SubscriptionPortAccess {

    fun getSubscription():List<Subscription>
    fun getSubscriptionById(subscriptionId: UUID):Subscription
    fun create(subscription: Subscription)
    fun update(subscriptionId: UUID, subscription: Subscription)
}