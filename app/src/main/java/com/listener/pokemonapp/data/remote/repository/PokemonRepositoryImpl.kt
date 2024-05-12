package com.listener.pokemonapp.data.remote.repository

import com.listener.pokemonapp.data.remote.PokeApi
import com.listener.pokemonapp.domain.models.Pokemon
import com.listener.pokemonapp.domain.models.PokemonDetails
import com.listener.pokemonapp.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val api: PokeApi) : PokemonRepository {

    override suspend fun loadPokemons(): List<Pokemon> {
        return api.getPokemonList(
            limit = 20,
            offset = 20
        ).results.map { result ->
            Pokemon(
                name = result.name,
                url = result.url
            )
        }
    }

    override suspend fun loadPokemonDetails(name: String): PokemonDetails {
        val response = api.getPokemonInfo(name)
        return PokemonDetails(
            id = response.id,
            name = response.name,
            weight = response.weight,
            height = response.height
        )
    }
}