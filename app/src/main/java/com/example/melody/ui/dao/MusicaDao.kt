package com.example.melody.ui.dao

import com.example.melody.ui.modelo.Musica

class MusicaDao {

    companion object {
       private val musicas = mutableListOf<Musica>(
            Musica(
                nomeMusica = "Harsh",
                nomeAutor = "Eleni Drake",
                imagemUrl = "https://lastfm.freetls.fastly.net/i/u/avatar170s/60bc7a064b7221fd9d8d97d6bfbe766b.jpg"
            ),
            Musica(
                nomeMusica = "Kids",
                nomeAutor = "Current Joys",
                imagemUrl = "https://f4.bcbits.com/img/a1983814605_10.jpg"
            ),
           Musica(
               nomeMusica = "Vienna",
               nomeAutor = "Billy Joel",
               imagemUrl = "https://akamai.sscdn.co/uploadfile/letras/albuns/d/8/1/5/328811391621018.jpg"
           ),
           Musica(
               nomeMusica = "Neon Lights",
               nomeAutor = "DOPE LEMON",
               imagemUrl = "https://i1.sndcdn.com/artworks-aZEa4KTpLFAd-0-t500x500.jpg"
           ),
           Musica(
               nomeMusica = "Elbow Pain",
               nomeAutor = "Glue Trip",
               imagemUrl = "https://i.ytimg.com/vi/ItuZ-dmcye4/maxresdefault.jpg"
           ),
           Musica(
               nomeMusica = "Call it Fate, Call it Karma",
               nomeAutor = "The Strokes",
               imagemUrl = "https://m.media-amazon.com/images/I/71hCmLtgqdL._SL1500_.jpg"
           ),
           Musica(
               nomeMusica = "Affection",
               nomeAutor = "Cigarettes After Sex",
               imagemUrl = "https://i.ytimg.com/vi/5soixb2U6xM/maxresdefault.jpg"
           ),
           Musica(
               nomeMusica = "Dancing in My Room",
               nomeAutor = "347aidan",
               imagemUrl = "https://lastfm.freetls.fastly.net/i/u/ar0/b4291148546881c1e00dde5ecd092022.jpg"
           )
        )
    }

    fun addMusic(musica: Musica) {
        musicas.add(musica)
    }

    fun showAll(): List<Musica> {
        return musicas.toList()
    }

    fun remove(position: Int){
        musicas.removeAt(position)
    }
}

