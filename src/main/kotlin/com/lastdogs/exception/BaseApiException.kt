package com.lastdogs.exception

import org.springframework.http.HttpStatus

open class BaseApiException : Throwable {
	var statusCode: HttpStatus = HttpStatus.UNPROCESSABLE_ENTITY
	var detailMessage: String? = null

	constructor(message: String?, detailMessage: String?, errorType: ErrorType) : super(message) {
		statusCode = errorType.httpStatus
		this.detailMessage = detailMessage
	}

}