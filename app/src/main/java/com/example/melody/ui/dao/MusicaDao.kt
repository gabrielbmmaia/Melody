package com.example.melody.ui.dao

import com.example.melody.ui.modelo.Musica

class MusicaDao {

    companion object {
        val musicas = mutableListOf<Musica>(
            Musica(
                nomeMusica = "Harsh",
                nomeAutor = "Eleni Drake",
                imagemUrl = "https://lastfm.freetls.fastly.net/i/u/avatar170s/60bc7a064b7221fd9d8d97d6bfbe766b.jpg"
            ),
            Musica(
                nomeAutor = "jorge",
                nomeMusica = "linguiça"
            )
        )
    }

    fun addMusic(musica: Musica) {
        musicas.add(musica)
    }

    fun showAll(): List<Musica> {
        return musicas.toList()
    }

}

