package com.lastdogs.secundary.repository

import com.lastdogs.secundary.dbo.SubscriptionDBO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface SubscriptionRepository:JpaRepository<SubscriptionDBO, UUID> {
}