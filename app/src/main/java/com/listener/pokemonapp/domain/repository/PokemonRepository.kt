package com.listener.pokemonapp.domain.repository

import com.listener.pokemonapp.domain.models.Pokemon
import com.listener.pokemonapp.domain.models.PokemonDetails

interface PokemonRepository {

    suspend fun loadPokemons(): List<Pokemon>

    suspend fun loadPokemonDetails(name: String): PokemonDetails

}