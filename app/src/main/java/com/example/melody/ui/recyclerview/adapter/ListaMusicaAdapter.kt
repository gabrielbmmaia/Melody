package com.example.melody.ui.recyclerview.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.melody.R
import com.example.melody.databinding.ExemploSomBinding
import com.example.melody.ui.modelo.Musica

class ListaMusicaAdapter(
    musicas: List<Musica>
) : RecyclerView.Adapter<ListaMusicaAdapter.ViewHolder>() {

    private val musicas = musicas.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = musicas.size

    class ViewHolder(binding: ExemploSomBinding) :
        RecyclerView.ViewHolder(binding.root) {

            private val nomeMusica = binding.exemploSomMusica
            private val nomeAutor = binding.exemploSomAutor
            private val imagemMusica = binding.exemploSomImagemview

        fun bind (musica: Musica){
            nomeMusica.text = musica.nomeMusica
            nomeAutor.text = musica.nomeAutor
            imagemMusica.load(musica.imagemUrl){
                fallback(R.drawable.image_not_found)
                error(R.drawable.image_not_found)
                placeholder(R.drawable.image_not_found)
            }
        }

    }
}