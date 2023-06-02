package com.example.homework7_android3.ui.fragments.pokemon

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework7_android3.R
import com.example.homework7_android3.baseFragment.BaseFragment
import com.example.homework7_android3.databinding.FragmentPokemonBinding
import com.example.homework7_android3.ui.adapters.PokemonAdapter
import kotlinx.coroutines.launch

class PokemonFragment :
    BaseFragment<FragmentPokemonBinding, PokemonViewModel>(R.layout.fragment_pokemon) {

    override val binding by viewBinding(FragmentPokemonBinding::bind)
    override val viewModel: PokemonViewModel by viewModels()
    private val pokemonAdapter = PokemonAdapter()

    override fun initialize() {
        super.initialize()
        binding.pokemonRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = pokemonAdapter
        }
    }

    override fun setupObserves() {
        super.setupObserves()
        lifecycleScope.launch {
            viewModel.fetchPokemon().collect {
                pokemonAdapter.submitList(it?.results)
            }
        }
    }
}