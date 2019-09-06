package com.lambdaschool.pokemonapi.model

import java.io.Serializable

class Pokemon (
    val name: String?,
    val sprites: List<String>?,
    val id: Int?,
    val abilities: List<String>?,
    val types: List<String>?
) : Serializable