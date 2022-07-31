package com.lastdogs.primary.account

import com.lastdogs.domain.account.port.AccountPortAccess
import com.lastdogs.primary.account.dto.request.CustomerRequest
import com.lastdogs.primary.account.dto.request.LoginRequest
import com.lastdogs.primary.account.dto.response.CreateAccountResponse
import com.lastdogs.primary.account.dto.response.LoginResponse
import com.lastdogs.primary.account.dto.response.toLoginResponse
import com.lastdogs.primary.account.dto.response.toResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/account")
class AccountController(
    private val accountPortAccess: AccountPortAccess
) {

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody accountRequest: CustomerRequest): CreateAccountResponse {
        return accountPortAccess.create(accountRequest.toModel()).toResponse()
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    fun login(@RequestBody loginRequest: LoginRequest): LoginResponse {
        return accountPortAccess.login(loginRequest.toModel()).toLoginResponse()
    }
}