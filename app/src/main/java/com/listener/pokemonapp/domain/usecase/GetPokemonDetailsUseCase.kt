package com.listener.pokemonapp.domain.usecase

import com.listener.pokemonapp.domain.models.PokemonDetails
import com.listener.pokemonapp.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonDetailsUseCase @Inject constructor(private val pokemonRepository: PokemonRepository) {

    suspend fun execute(name: String): PokemonDetails {
        return pokemonRepository.loadPokemonDetails(name)
    }
}