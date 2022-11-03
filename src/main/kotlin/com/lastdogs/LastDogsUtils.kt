package com.lastdogs

import java.util.Optional

fun <T> Optional<T>.getOrNull(): T?{
	if(this.isPresent) return this.get()
	return null
}