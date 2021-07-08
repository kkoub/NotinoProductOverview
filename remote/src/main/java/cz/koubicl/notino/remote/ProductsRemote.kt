package cz.koubicl.notino.remote

import cz.koubicl.notino.remote.model.GetProductsResponse
import cz.koubicl.notino.remote.service.NotinoServiceProvider
import io.reactivex.Single

class ProductsRemote(private val serviceProvider: NotinoServiceProvider) {

    // TODO ERROR HANDLING
    fun getProducts(): Single<GetProductsResponse> = serviceProvider.service.getProducts()
}