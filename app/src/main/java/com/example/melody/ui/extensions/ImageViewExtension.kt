package com.example.melody.ui.extensions

import android.widget.ImageView
import coil.load
import com.example.melody.R

fun ImageView.tryLoadImage(url: String?) {
    load(url) {
        fallback(R.drawable.image_not_found)
        error(R.drawable.image_not_found)
        placeholder(R.drawable.image_not_found)
    }
}