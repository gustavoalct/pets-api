package com.lastdogs.primary.subscription

import com.lastdogs.domain.subscriptions.model.Subscription
import com.lastdogs.domain.subscriptions.port.SubscriptionPortAccess
import com.lastdogs.primary.subscription.dto.request.SubscriptionRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID


@RestController
@RequestMapping("/subscription")
class SubscriptionController(
    private val subscriptionPortAccess: SubscriptionPortAccess
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getSubscription(): List<Subscription> {
        return subscriptionPortAccess.getAllSubscriptions();
    }

    @GetMapping("/{subscriptionId}")
    @ResponseStatus(HttpStatus.OK)
    fun getSubscriptionById(@PathVariable subscriptionId:UUID) =
        subscriptionPortAccess.getSubscriptionById(subscriptionId)

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun create(@RequestBody subscriptionRequest: SubscriptionRequest) =
        subscriptionPortAccess.create(subscriptionRequest.toModel())

    @PatchMapping("/{subscriptionId}")
    @ResponseStatus(HttpStatus.OK)
    fun update(
        @PathVariable subscriptionId: UUID,
        @RequestBody subscriptionRequest: SubscriptionRequest
    ) = subscriptionPortAccess.update(subscriptionId, subscriptionRequest.toModel())

}