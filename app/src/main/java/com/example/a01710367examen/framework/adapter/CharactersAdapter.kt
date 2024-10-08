package com.example.a01710367examen.framework.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.a01710367examen.data.models.DBCharacter
import com.example.a01710367examen.databinding.ItemCharacterBinding

class CharactersAdapter(private val onCharacterClick: (DBCharacter) -> Unit) :
    ListAdapter<DBCharacter, CharactersAdapter.CharacterViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = getItem(position)
        holder.bind(character)
        // Añadir evento click
        holder.itemView.setOnClickListener {
            onCharacterClick(character)
        }
    }

    class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(character: DBCharacter) {
            Glide.with(binding.characterImage.context)
                .load(character.image)
                .into(binding.characterImage)
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<DBCharacter>() {
        override fun areItemsTheSame(oldItem: DBCharacter, newItem: DBCharacter): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: DBCharacter, newItem: DBCharacter): Boolean =
            oldItem == newItem
    }
}
