package com.lastdogs.secundary.dbo

import com.lastdogs.domain.subscriptions.model.Subscription
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity(name = "subscription")
@Table(name = "subscription")
data class SubscriptionDBO(
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	val id: UUID? = UUID.randomUUID(),
	@Column(name = "full_name")
	val fullName: String,

	@CreatedDate
	@Column(updatable = false)
	var createdAt: LocalDateTime? = LocalDateTime.now(),

	@LastModifiedDate
	var updatedAt: LocalDateTime? = LocalDateTime.now(),
){
	fun toModel() = Subscription(
		id = id,
		fullName = fullName
	)
}

fun Subscription.toDBO() = SubscriptionDBO(
	id = id,
	fullName = fullName
)
