package cz.koubicl.example.presentation.extensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations

fun <T, S> LiveData<T>.map(function: (T) -> S) = Transformations.map(this, function)