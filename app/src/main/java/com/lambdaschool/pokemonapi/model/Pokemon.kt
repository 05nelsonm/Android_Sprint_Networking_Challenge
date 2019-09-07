package com.lambdaschool.pokemonapi.model

import java.io.Serializable

data class PokemonSerial(
    var name: String,
    var sprites: String,
    var id: Int,
    var ability: MutableList<String>,
    var type: MutableList<String>
) : Serializable

data class Pokemon (
    val name: String,
    val sprites: SpritesUrl,
    val id: Int,
    val abilities: List<Ability>,
    val types: List<Type>
)

data class SpritesUrl (
    val front_default: String
)

data class Ability (
    val ability: AbilityName
)

data class AbilityName (
    val name: String
)

data class Type (
    val type: TypeName
)

data class TypeName (
    val name: String
)