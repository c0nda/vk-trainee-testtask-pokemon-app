package com.listener.pokemonapp.di.app

import com.listener.pokemonapp.data.remote.repository.PokemonRepositoryImpl
import com.listener.pokemonapp.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module


@Module
abstract class RepositoryModule {

    @Binds
    abstract fun providePokemonRepository(
        pokemonRepositoryImpl: PokemonRepositoryImpl
    ): PokemonRepository
}