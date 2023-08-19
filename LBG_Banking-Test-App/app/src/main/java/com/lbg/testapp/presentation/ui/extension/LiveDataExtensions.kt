package com.lbg.testapp.presentation.ui.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Created by Siva kumar boddu 
 */
fun <T> LiveData<T>.observe(lifecycleOwner: LifecycleOwner, body: (T) -> Unit) {
    this.observe(lifecycleOwner, Observer { body(it) })
}