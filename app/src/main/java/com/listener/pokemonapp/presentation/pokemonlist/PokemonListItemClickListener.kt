package com.listener.pokemonapp.presentation.pokemonlist

import com.listener.pokemonapp.domain.models.Pokemon

interface PokemonListItemClickListener {
    fun onPokemonSelected(pokemon: Pokemon)
}