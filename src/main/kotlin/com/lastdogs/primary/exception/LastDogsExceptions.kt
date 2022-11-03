package com.lastdogs.primary.exception

import com.lastdogs.exception.BaseApiException
import com.lastdogs.exception.ErrorType

class LastDogsExceptions(message: String?, detailMessage: String?, errorType: ErrorType) :
	BaseApiException(message, detailMessage, errorType) {
}