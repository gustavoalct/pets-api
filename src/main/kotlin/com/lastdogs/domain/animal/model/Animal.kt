package com.lastdogs.domain.animal.model

import java.util.UUID

data class Animal (

    val id: UUID ? = UUID.randomUUID(),
    val name:String,
    val age:Int,
    val animalType: AnimalType,
    val animalSize: AnimalSize,
    val breed: String,
    val color: String ?=null
)