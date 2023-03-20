package com.example.groceryapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.example.groceryapp.R
import com.example.groceryapp.utils.Constants.BASE_IMAGE_URL


class BindingAdapters {

    companion object {

        @JvmStatic
        @BindingAdapter("imageSource")
        fun loadImageFromServer(imageView: ImageView, url: String?) = with(url) {
            if (!isNullOrEmpty()) {
                Picasso
                    .get()
                    .load("$BASE_IMAGE_URL$this")
                    .error(R.drawable.ic_launcher_foreground)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageView)
            }
        }
    }
}