package com.example.melody.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.melody.R
import com.example.melody.databinding.FormularioMusicaActivityBinding
import com.example.melody.ui.dao.MusicaDao
import com.example.melody.ui.modelo.Musica

class FormularioMusicaActivity : AppCompatActivity(R.layout.formulario_musica_activity){

    private val binding by lazy {
        FormularioMusicaActivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "New Song"
        configuraEfab()
        binding.formularioMusicaActivityImageview.setOnClickListener {

        }

    }

    private fun configuraEfab() {
        binding.formularioMusicaButton.setOnClickListener {
            val newSong = newSong()
            val dao = MusicaDao()
            dao.addMusic(newSong)
            finish()
        }
    }

    private fun newSong(): Musica {
        val campoMusica = binding.formularioMusicaEditTextCampomusica.text.toString()
        val campoAutor = binding.formularioMusicaEditTextCampoautor.text.toString()

        return Musica(
            nomeMusica = campoMusica,
            nomeAutor = campoAutor
        )
    }
}
