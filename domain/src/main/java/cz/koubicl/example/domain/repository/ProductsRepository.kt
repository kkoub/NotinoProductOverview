package cz.koubicl.example.domain.repository

import cz.koubicl.example.domain.mapper.ProductsMapper
import cz.koubicl.example.domain.model.Products
import cz.koubicl.example.remote.ProductsRemote
import io.reactivex.Single

class ProductsRepository(
    private val mapper: ProductsMapper,
    private val remote: ProductsRemote
) {
    fun getProducts(): Single<Products> =
        remote
            .getProducts()
            .map { mapper.fromResponse(it) }
}