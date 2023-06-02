package com.example.homework7_android3.data.remote

import com.example.homework7_android3.data.remote.apiservices.PokemonApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun providePokemonApiService(): PokemonApiService {
        return retrofitClient.create(PokemonApiService::class.java)
    }
}