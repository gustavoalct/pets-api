package com.lastdogs.secundary.repository

import com.lastdogs.secundary.dbo.CustomerDBO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID


@Repository
interface CustomerRepository : JpaRepository<CustomerDBO, UUID> {
    fun findByEmailAndPassword(email: String, password: String): CustomerDBO?
    fun findByEmail(email: String):CustomerDBO?
}