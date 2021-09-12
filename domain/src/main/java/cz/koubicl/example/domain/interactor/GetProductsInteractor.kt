package cz.koubicl.example.domain.interactor

import cz.koubicl.example.domain.repository.ProductsRepository

class GetProductsInteractor(
    private val repository: ProductsRepository
) {

    fun getProducts() = repository.getProducts()
}