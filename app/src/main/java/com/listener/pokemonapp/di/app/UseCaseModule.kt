package com.listener.pokemonapp.di.app

import com.listener.pokemonapp.domain.repository.PokemonRepository
import com.listener.pokemonapp.domain.usecase.GetPokemonDetailsUseCase
import com.listener.pokemonapp.domain.usecase.GetPokemonsUseCase
import dagger.Module
import dagger.Provides


@Module
class UseCaseModule {

    @Provides
    fun provideGetPokemonDetailsUseCase(pokemonRepository: PokemonRepository) =
        GetPokemonDetailsUseCase(pokemonRepository)

    @Provides
    fun provideGetPokemonsUseCase(pokemonRepository: PokemonRepository) =
        GetPokemonsUseCase(pokemonRepository)

}