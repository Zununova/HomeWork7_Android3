package com.example.homework7_android3.data.repository

import android.util.Log
import com.example.homework7_android3.App
import com.example.homework7_android3.models.PokemonModel
import com.example.homework7_android3.models.PokemonResponse
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepository {

    fun fetchPokemon(): Flow<PokemonResponse<PokemonModel>?> = callbackFlow {
        val callback = object : Callback<PokemonResponse<PokemonModel>?> {
            override fun onResponse(
                call: Call<PokemonResponse<PokemonModel>?>,
                response: Response<PokemonResponse<PokemonModel>?>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    trySend(response.body()!!).isSuccess
                }
            }

            override fun onFailure(call: Call<PokemonResponse<PokemonModel>?>, t: Throwable) {
                trySend(null).isFailure
                Log.e("error", t.localizedMessage ?: "Error")
            }
        }

        App.pokemonApi?.fetchPokemon()?.enqueue(callback)

        awaitClose {
            App.pokemonApi?.fetchPokemon()?.cancel()
        }
    }
}
