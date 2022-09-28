package com.example.melody.ui.dao

import com.example.melody.ui.modelo.Musica

class MusicaDao {

    companion object{
        private val musicas = mutableListOf<Musica>()
    }

    fun addMusic(musica: Musica){
        musicas.add(musica)
    }

    fun showAll() : List<Musica>{
        return musicas.toList()
    }

}