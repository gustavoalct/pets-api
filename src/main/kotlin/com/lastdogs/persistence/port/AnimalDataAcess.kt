package com.lastdogs.persistence.port

import com.lastdogs.domain.animal.model.Animal

interface AnimalDataAcess {

    fun create(animal: Animal):Animal
}