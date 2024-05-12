package com.listener.pokemonapp.presentation.pokemondetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.listener.pokemonapp.domain.models.PokemonDetails
import com.listener.pokemonapp.domain.usecase.GetPokemonDetailsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonDetailsViewModel @Inject constructor(
    private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase
) : ViewModel() {

    private val _pokemonDetails = MutableLiveData<PokemonDetails>()
    val pokemonDetails: LiveData<PokemonDetails> = _pokemonDetails

    fun loadPokemonDetails(name: String) {
        viewModelScope.launch {
            try {
                _pokemonDetails.postValue(getPokemonDetailsUseCase.execute(name))
            } catch (e: Exception) {
                Log.e("e", e.printStackTrace().toString())
            }
        }
    }
}