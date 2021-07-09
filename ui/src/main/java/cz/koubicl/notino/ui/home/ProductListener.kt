package cz.koubicl.notino.ui.home

import cz.koubicl.notino.presentation.model.ProductItemModel

interface ProductListener {
    fun addToCart(product: ProductItemModel)
}