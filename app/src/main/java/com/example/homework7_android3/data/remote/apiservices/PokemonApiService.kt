package com.example.homework7_android3.data.remote.apiservices

import com.example.homework7_android3.models.PokemonModel
import com.example.homework7_android3.models.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET

interface PokemonApiService {

    @GET("api/v2/pokemon/")
    fun fetchPokemon(): Call<PokemonResponse<PokemonModel>>

}