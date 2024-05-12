package com.listener.pokemonapp.domain.usecase

import com.listener.pokemonapp.domain.models.Pokemon
import com.listener.pokemonapp.domain.repository.PokemonRepository

class GetPokemonsUseCase(private val pokemonRepository: PokemonRepository) {

    suspend fun execute(): List<Pokemon> {
        return pokemonRepository.loadPokemons()
    }
}