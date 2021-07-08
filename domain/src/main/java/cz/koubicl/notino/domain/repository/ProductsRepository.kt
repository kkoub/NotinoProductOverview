package cz.koubicl.notino.domain.repository

import cz.koubicl.notino.domain.mapper.ProductsMapper
import cz.koubicl.notino.domain.model.Products
import cz.koubicl.notino.remote.ProductsRemote
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