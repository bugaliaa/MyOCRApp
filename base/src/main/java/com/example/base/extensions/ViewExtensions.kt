package com.example.base.extensions

import android.graphics.drawable.Drawable
import android.view.View
import android.view.animation.AnimationUtils
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.updatePadding
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

fun View.goneIfVisible() {
    if (visibility != View.GONE) visibility = View.GONE
}

fun View.invisibleIfVisible() {
    if (visibility != View.INVISIBLE) visibility = View.INVISIBLE
}

fun View.visibleIfGone() {
    if (visibility != View.VISIBLE) visibility = View.VISIBLE
}

fun View.fadeOut() {
    if (visibility == View.GONE) return
    startAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_out))
    goneIfVisible()
}

fun View.fadeIn() {
    visibleIfGone()
    startAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_in))
}

fun View.addPadding(left: Int = 0, top: Int = 0, right: Int = 0, bottom: Int = 0) {
    updatePadding(
        left = paddingLeft + left,
        top = paddingTop + top,
        right = paddingRight + right,
        bottom = paddingBottom + bottom
    )
}

fun ImageView.loadImageFrom(url: String?) {
    url?.let {
        Glide.with(context).load(it).into(this)
    }
}

fun ImageView.loadDrawableImage(resID: Drawable?){
    resID?.let {
        Glide.with(context).load(resID).into(this)
    }
}

fun AppCompatImageView.loadImageFrom(url: String?) {
    url?.let {
        Glide.with(context).load(it).into(this)
    }
}

fun AppCompatImageView.loadCircularImageFrom(url: String?) {
    url?.let {
        Glide.with(context).load(url).into(this)
    }
}

fun AppCompatImageView.loadDrawableImage(resID: Drawable){
    Glide.with(context).load(resID).transition(DrawableTransitionOptions.withCrossFade()).into(this)
}

fun RecyclerView.supportsChangeAnimation(enabled: Boolean) {
    (itemAnimator as? DefaultItemAnimator)?.supportsChangeAnimations = enabled
}

fun EditText.doneListener(onDone: () -> Unit) {
    setOnEditorActionListener { _, actionId, _ ->

        if ((actionId == EditorInfo.IME_ACTION_DONE)) {
            onDone()
            return@setOnEditorActionListener true
        }
        return@setOnEditorActionListener false
    }
}