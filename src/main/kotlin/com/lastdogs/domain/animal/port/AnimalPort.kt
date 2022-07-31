package com.lastdogs.domain.animal.port

import com.lastdogs.domain.animal.model.Animal

interface AnimalPort {

    fun create(animal: Animal):Animal
}