package com.lastdogs.primary.animal.dto

import com.lastdogs.domain.animal.model.Animal
import com.lastdogs.domain.animal.model.AnimalSize
import com.lastdogs.domain.animal.model.AnimalType

data class AnimalDTO(

    val name:String,
    val age:Int,
    val animalType: AnimalType,
    val animalSize: AnimalSize,
    val breed: String,
    val color: String ?=null
){
    fun toModel() = Animal(
        name = name,
        age = age,
        animalSize = animalSize,
        animalType = animalType,
        breed = breed,
        color = color
    )
}
