package com.example.melody.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.melody.R
import com.example.melody.databinding.ListaMusicaActivityBinding
import com.example.melody.ui.dao.MusicaDao
import com.example.melody.ui.recyclerview.adapter.ListaMusicaAdapter
import java.util.*

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
        helper.attachToRecyclerView(binding.listaMusicaActivityRecyclerview)
    }

    val helper = ItemTouchHelper(
        ItemTouchHelper(
            androidx.recyclerview.widget.ItemTouchHelper.UP
                    or androidx.recyclerview.widget.ItemTouchHelper.DOWN,
            androidx.recyclerview.widget.ItemTouchHelper.RIGHT
        )
    )

    inner class ItemTouchHelper(dragDirs: Int, swipeDirs: Int) :
        androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs) {

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            val from: Int = viewHolder.bindingAdapterPosition
            val to: Int = target.bindingAdapterPosition
            Collections.swap(MusicaDao.musicas, from, to)
            adapter.notifyItemMoved(from, to)
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            adapter.showList().removeAt(viewHolder.bindingAdapterPosition)
            adapter.notifyItemRemoved(viewHolder.bindingAdapterPosition)
        }
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

