package com.example.melody.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.melody.R
import com.example.melody.databinding.ListaMusicaActivityBinding
import com.example.melody.ui.dao.MusicaDao
import com.example.melody.ui.recyclerview.adapter.ListaMusicaAdapter

class ListaMusicaActivity : AppCompatActivity(R.layout.lista_musica_activity) {

    private val dao = MusicaDao()
    private val adapter = ListaMusicaAdapter(dao.showAll())
    private val binding by lazy {
        ListaMusicaActivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        createRecyclerView()
        createEfab()
    }

    override fun onResume() {
        super.onResume()
        adapter.refresh(dao.showAll())
    }

    private fun createRecyclerView() {
        val recyclerView = binding.listaMusicaActivityRecyclerview
        recyclerView.adapter = adapter
    }

    private fun createEfab() {
        val efab = binding.listaMusicaActivityEfab
        efab.setOnClickListener {
            val intent = Intent(this, FormularioMusicaActivity::class.java)
            startActivity(intent)
        }
    }

}