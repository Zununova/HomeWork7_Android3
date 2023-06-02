package com.example.homework7_android3.ui.fragments.pokemon

import androidx.lifecycle.ViewModel
import com.example.homework7_android3.data.repository.PokemonRepository

class PokemonViewModel : ViewModel() {

    private val pokemonRepository = PokemonRepository()

    fun fetchPokemon() = pokemonRepository.fetchPokemon()
}