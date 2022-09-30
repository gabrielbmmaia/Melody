package com.example.melody.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.melody.databinding.FormularioLayoutDialogBinding
import com.example.melody.ui.extensions.tryLoadImage

class DialogFormularioImage(private val context: Context) {

    fun mostra(
        urlImagem: String? = null,
        pegarImagem: (url: String) -> Unit
    ) {
        FormularioLayoutDialogBinding
            .inflate(LayoutInflater.from(context)).apply {
                urlImagem?.let {
                    formularioDialogImageview.tryLoadImage(it)
                    formularioDialogEditTextUrlimage.setText(it)
                }
                formularioDialogButton.setOnClickListener {
                    val url = formularioDialogEditTextUrlimage.text.toString()
                    formularioDialogImageview.tryLoadImage(url)
                }
                AlertDialog.Builder(context)
                    .setView(root)
                    .setPositiveButton("Confirm") { _, _ ->
                        val url = formularioDialogEditTextUrlimage.text.toString()
                        pegarImagem(url)
                    }
                    .setNegativeButton("Cancel") { _, _ -> }
                    .show()
            }
    }
}