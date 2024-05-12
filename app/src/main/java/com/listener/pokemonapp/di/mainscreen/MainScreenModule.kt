package com.listener.pokemonapp.di.mainscreen

import androidx.lifecycle.ViewModel
import com.listener.pokemonapp.presentation.pokemondetails.PokemonDetailsViewModel
import com.listener.pokemonapp.presentation.pokemonlist.PokemonListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainScreenModule {

    @Binds
    @IntoMap
    @ViewModelKey(PokemonListViewModel::class)
    abstract fun pokemonListViewModel(viewModel: PokemonListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PokemonDetailsViewModel::class)
    abstract fun pokemonDetailsViewModel(viewModel: PokemonDetailsViewModel): ViewModel
}