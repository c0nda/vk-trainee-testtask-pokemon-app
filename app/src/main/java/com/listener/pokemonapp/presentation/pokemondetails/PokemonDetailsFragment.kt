package com.listener.pokemonapp.presentation.pokemondetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import coil.load
import com.listener.pokemonapp.R
import com.listener.pokemonapp.di.mainscreen.MainScreenComponent
import com.listener.pokemonapp.domain.models.PokemonDetails
import com.listener.pokemonapp.presentation.pokemondetails.PokemonDetailsFragmentDirections

class PokemonDetailsFragment : Fragment() {

    private val component by lazy { MainScreenComponent.create() }

    private val pokemonDetailsViewModel by viewModels<PokemonDetailsViewModel> {
        component.viewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pokemon_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        val pokemon = bundle?.getSerializable("name") as String
        pokemonDetailsViewModel.loadPokemonDetails(pokemon)

        pokemonDetailsViewModel.pokemonDetails.observe(viewLifecycleOwner) { details ->
            updatePokemonDetailsInfo(details)
        }

        val back = view.findViewById<ImageButton>(R.id.ib_back)
        back.setOnClickListener {
            navigateToPokemonListFragment()
        }
    }

    private fun updatePokemonDetailsInfo(details: PokemonDetails) {
        view?.findViewById<ImageView>(R.id.iv_image_details)
            ?.load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${details.id}.png")
        view?.findViewById<TextView>(R.id.tv_name_details)?.text =
            context?.getString(R.string.name, details.name)
        view?.findViewById<TextView>(R.id.tv_height)?.text =
            context?.getString(R.string.height, details.height)
        view?.findViewById<TextView>(R.id.tv_weight)?.text =
            context?.getString(R.string.weight, details.weight)
    }

    private fun navigateToPokemonListFragment() {
        val action =
            PokemonDetailsFragmentDirections.actionPokemonDetailsFragmentToPokemonListFragment()
        findNavController().navigate(action)
    }
}