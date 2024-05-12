package com.listener.pokemonapp.presentation.pokemonlist

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.listener.pokemonapp.R
import com.listener.pokemonapp.domain.models.Pokemon

class PokemonListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val name: TextView = itemView.findViewById(R.id.tv_name)
    private val image: ImageView = itemView.findViewById(R.id.iv_image)

    fun bind(pokemon: Pokemon, listener: PokemonListItemClickListener) {
        val number = if(pokemon.url.endsWith("/")) {
            pokemon.url.dropLast(1).takeLastWhile { it.isDigit() }
        } else {
            pokemon.url.takeLastWhile { it.isDigit() }
        }
        image.load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png")
        name.text = pokemon.name
        itemView.setOnClickListener {
            listener.onPokemonSelected(pokemon)
        }
    }
}