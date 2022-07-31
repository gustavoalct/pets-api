package com.lastdogs.persistence.adpter

import com.lastdogs.domain.animal.model.Animal
import com.lastdogs.persistence.port.AnimalDataAcess
import org.springframework.stereotype.Component

@Component
class AnimalAdapter (

):AnimalDataAcess{

    override fun create(animal: Animal):Animal {
        println(animal)
        return animal
    }
}