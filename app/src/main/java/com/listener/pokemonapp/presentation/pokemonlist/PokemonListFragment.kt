package com.listener.pokemonapp.presentation.pokemonlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.listener.pokemonapp.R
import com.listener.pokemonapp.di.mainscreen.MainScreenComponent
import com.listener.pokemonapp.domain.models.Pokemon

class PokemonListFragment : Fragment() {

    private val component by lazy { MainScreenComponent.create() }

    private val pokemonListViewModel by viewModels<PokemonListViewModel> {
        component.viewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pokemons, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_pokemons)
        recyclerView.apply {
            val pokemonAdapter = PokemonAdapter(object : PokemonListItemClickListener {
                override fun onPokemonSelected(pokemon: Pokemon) {
                    val bundle = Bundle()
                    bundle.putSerializable("name", pokemon.name)
                    findNavController().navigate(
                        R.id.action_pokemonListFragment_to_pokemonDetailsFragment,
                        bundle
                    )
                }
            })
            recyclerView.adapter = pokemonAdapter
            layoutManager = LinearLayoutManager(this.context)
            loadDataToAdapter(pokemonAdapter)
        }
    }

    private fun loadDataToAdapter(adapter: PokemonAdapter) {
        pokemonListViewModel.pokemons.observe(viewLifecycleOwner) { pokemons ->
            adapter.submitList(pokemons)
        }
    }
}