package com.lastdogs.domain.subscriptions.port


interface SubscriptionPortAccess {

    fun getSubscription():List<subscription>

}