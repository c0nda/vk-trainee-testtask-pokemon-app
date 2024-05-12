package com.listener.pokemonapp.presentation.pokemonlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.listener.pokemonapp.domain.models.Pokemon
import com.listener.pokemonapp.domain.usecase.GetPokemonsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonListViewModel @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase
) : ViewModel() {

    private val _pokemons = MutableLiveData<List<Pokemon>>(emptyList())
    val pokemons: LiveData<List<Pokemon>> = _pokemons

    init {
        loadPokemons()
    }

    private fun loadPokemons() {
        viewModelScope.launch {
            try {
                _pokemons.postValue(getPokemonsUseCase.execute())
            } catch (e: Exception) {
                Log.e("e", e.printStackTrace().toString())
            }
        }
    }
}