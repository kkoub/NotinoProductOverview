package cz.koubicl.notino.domain.interactor

import cz.koubicl.notino.domain.repository.ProductsRepository

class GetProductsInteractor(
    private val repository: ProductsRepository
) {

    fun getProducts() = repository.getProducts()
}