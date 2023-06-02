package com.example.homework7_android3.models

import com.google.gson.annotations.SerializedName

data class PokemonResponse<T>(

    @SerializedName("info")
    val info: Info,

    @SerializedName("results")
    val results: List<T>

)
