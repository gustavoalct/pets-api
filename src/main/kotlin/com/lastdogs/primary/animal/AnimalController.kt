package com.lastdogs.primary.animal

import com.lastdogs.domain.animal.model.Animal
import com.lastdogs.domain.animal.port.AnimalPort
import com.lastdogs.primary.animal.dto.AnimalDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/animal")
class AnimalController(

    private val animalPort: AnimalPort
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody animalDTO: AnimalDTO): Animal {
        // val id: UUID? = animalPort.create(animalDTO.toModel()).id
        return animalPort.create(animalDTO.toModel())
    }
}