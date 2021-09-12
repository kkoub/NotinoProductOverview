package cz.koubicl.example.presentation.extensions

import cz.koubicl.example.domain.model.AmountValue

fun AmountValue.format(): String {
    return "$value ${currency.formatCurrency()}"
}

fun String.formatCurrency(): String {
    return when (this) {
        "CZK" -> "Kč"
        "EUR" -> "€"
        else -> this
    }
}