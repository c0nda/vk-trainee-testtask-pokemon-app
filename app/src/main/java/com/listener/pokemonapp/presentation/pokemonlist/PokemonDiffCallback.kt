package com.listener.pokemonapp.presentation.pokemonlist

import androidx.recyclerview.widget.DiffUtil
import com.listener.pokemonapp.domain.models.Pokemon

class PokemonDiffCallback : DiffUtil.ItemCallback<Pokemon>() {

    override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem == newItem
    }
}