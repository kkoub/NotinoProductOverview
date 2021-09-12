package cz.koubicl.example.remote

import cz.koubicl.example.remote.model.GetProductsResponse
import cz.koubicl.example.remote.service.ExampleServiceProvider
import io.reactivex.Single

class ProductsRemote(private val serviceProvider: ExampleServiceProvider) {

    // TODO ERROR HANDLING
    fun getProducts(): Single<GetProductsResponse> = serviceProvider.service.getProducts()
}