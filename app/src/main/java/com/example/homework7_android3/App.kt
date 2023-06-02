package com.example.homework7_android3

import android.app.Application
import com.example.homework7_android3.data.remote.RetrofitClient
import com.example.homework7_android3.data.remote.apiservices.PokemonApiService

class App : Application() {

    companion object {
        var pokemonApi: PokemonApiService? = null
    }

    override fun onCreate() {
        super.onCreate()
        val retrofitClient = RetrofitClient()
        pokemonApi = retrofitClient.providePokemonApiService()

    }
}