package com.muratcay.beinconnecttestcase.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.muratcay.remote.utils.RemoteConstants.IMAGE_BASE_URL

fun ImageView.loadImage(url: String?) {
    val imageUrl = IMAGE_BASE_URL + url
    Glide.with(context).load(imageUrl).centerCrop().into(this)
}