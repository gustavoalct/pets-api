package com.lastdogs.exception

import org.springframework.http.HttpStatus

enum class ErrorType(val httpStatus: HttpStatus) {
	ALREADY_EXIST(HttpStatus.CONFLICT),
	NOT_FOUND(HttpStatus.NOT_FOUND)

}