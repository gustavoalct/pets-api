package com.lastdogs.primary.customer

import com.lastdogs.domain.customer.port.CustomerPortAccess
import com.lastdogs.primary.customer.dto.request.CustomerRequest
import com.lastdogs.primary.customer.dto.response.CreateAccountResponse
import com.lastdogs.primary.customer.dto.response.toResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/account")
class CustomerController(
    private val accountPortAccess: CustomerPortAccess
) {

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody accountRequest: CustomerRequest): CreateAccountResponse {
        return accountPortAccess.create(accountRequest.toModel()).toResponse()
    }


}