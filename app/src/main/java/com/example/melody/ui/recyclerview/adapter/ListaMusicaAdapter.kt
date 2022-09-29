package com.example.melody.ui.recyclerview.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.melody.databinding.ExemploSomBinding
import com.example.melody.ui.extensions.tryLoadImage
import com.example.melody.ui.modelo.Musica

class ListaMusicaAdapter(
    musicas: List<Musica>
) : RecyclerView.Adapter<ListaMusicaAdapter.ViewHolder>() {

    private val musicas = musicas.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ExemploSomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(musicas[position])
    }

    override fun getItemCount(): Int = musicas.size

    @SuppressLint("NotifyDataSetChanged")
    fun refresh(musica: List<Musica>) {
        this.musicas.clear()
        this.musicas.addAll(musica)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ExemploSomBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val nomeMusica = binding.exemploSomMusica
        private val nomeAutor = binding.exemploSomAutor
        private val imagemMusica = binding.exemploSomImagemview

        fun bind(musica: Musica) {
            nomeMusica.text = musica.nomeMusica
            nomeAutor.text = musica.nomeAutor
            imagemMusica.tryLoadImage(musica.imagemUrl)
            imagemMusica.visibility =
                visibilidade(musica) // função para deixar a musica sem imagem caso nenhum seja adicionada
        }
        private fun visibilidade(musica: Musica) =
            if (musica.imagemUrl != null) {
                View.VISIBLE
            } else {
                View.GONE
            }
    }
}