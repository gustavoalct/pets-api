package com.lastdogs.domain.animal.usecase

import com.lastdogs.domain.animal.model.Animal
import com.lastdogs.domain.animal.port.AnimalPort
import com.lastdogs.persistence.port.AnimalDataAcess
import org.springframework.stereotype.Component

@Component
class AnimalUsecase(
    private val animalDataAcess: AnimalDataAcess
):AnimalPort {

    override fun create(animal: Animal): Animal {

        return animalDataAcess.create(animal)
    }
}