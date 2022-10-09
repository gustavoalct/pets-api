package com.lastdogs.primary.authentication

import com.lastdogs.domain.authentication.port.AuthenticationPortAccess
import com.lastdogs.domain.customer.port.CustomerPortAccess
import com.lastdogs.primary.customer.dto.request.LoginRequest
import com.lastdogs.primary.customer.dto.response.LoginResponse
import com.lastdogs.primary.customer.dto.response.toLoginResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/authentication")
class AuthenticationController(
    private val authenticationPortAccess: AuthenticationPortAccess
) {

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    fun login(@RequestBody loginRequest: LoginRequest): LoginResponse? {
        return authenticationPortAccess.login(loginRequest.toModel())?.toLoginResponse()
    }
}