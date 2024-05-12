package com.listener.pokemonapp.presentation.pokemonlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.listener.pokemonapp.R
import com.listener.pokemonapp.domain.models.Pokemon

class PokemonAdapter(private val listener: PokemonListItemClickListener) :
    ListAdapter<Pokemon, PokemonListViewHolder>(PokemonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        return PokemonListViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.viewholder_pokemon, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, listener)
    }

}