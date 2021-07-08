package cz.koubicl.notino.presentation.extensions

import cz.koubicl.notino.domain.model.AmountValue

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