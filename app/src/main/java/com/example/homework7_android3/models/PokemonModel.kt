package com.example.homework7_android3.models

import com.google.gson.annotations.SerializedName

data class PokemonModel(

    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("base_experience")
    var base_experience: Int,

    @SerializedName("height")
    var height: Int,

    @SerializedName("order")
    var order: Int,

    @SerializedName("weight")
    var weight: Int
)
