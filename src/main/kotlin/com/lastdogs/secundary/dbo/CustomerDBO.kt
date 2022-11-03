package com.lastdogs.secundary.dbo

import com.lastdogs.domain.customer.model.Customer
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity(name = "user_account")
@Table(name = "user_account")
data class CustomerDBO(

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    val id: UUID? = UUID.randomUUID(),
    @Column(name = "full_name")
    val fullName: String,
    val email: String,
    @Column(name="customer_password")
    val password: String,

    @CreatedDate
    @Column(updatable = false)
    var createdAt: LocalDateTime? = LocalDateTime.now(),

    @LastModifiedDate
    var updatedAt: LocalDateTime? = LocalDateTime.now(),
) {
    fun toModel() = Customer(
        id = id,
        userName = fullName,
        email = email,
        password = password
    )
}

fun Customer.toDBO() = CustomerDBO(
    id = id,
    fullName = userName,
    email = email!!,
    password = password
)
