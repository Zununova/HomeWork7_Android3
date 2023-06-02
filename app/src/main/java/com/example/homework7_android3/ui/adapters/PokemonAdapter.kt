package com.example.homework7_android3.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework7_android3.databinding.OneItemBinding
import com.example.homework7_android3.models.PokemonModel

class PokemonAdapter :
    ListAdapter<PokemonModel, PokemonAdapter.PokemonViewHolder>(DiffUtilCallback()) {

    class PokemonViewHolder(private val binding: OneItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(pokemonModel: PokemonModel?) {
            Glide.with(binding.imageViewHero)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + pokemonModel?.id + ".png")
                .into(binding.imageViewHero)
            binding.textViewNameHero.text = pokemonModel?.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            OneItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemonModel = getItem(position)
        pokemonModel?.id = position + 1
        holder.onBind(pokemonModel)
    }

    companion object {

        class DiffUtilCallback : DiffUtil.ItemCallback<PokemonModel>() {

            override fun areItemsTheSame(
                oldItem: PokemonModel,
                newItem: PokemonModel
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: PokemonModel,
                newItem: PokemonModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}

