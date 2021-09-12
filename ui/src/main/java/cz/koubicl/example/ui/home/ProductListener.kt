package cz.koubicl.example.ui.home

import cz.koubicl.example.presentation.model.ProductItemModel

interface ProductListener {
    fun addToCart(product: ProductItemModel)
}