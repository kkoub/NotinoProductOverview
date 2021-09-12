package cz.koubicl.example.remote.service

import cz.koubicl.example.remote.model.GetProductsResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ExampleService {
    @GET("koubicl/AnExample/db")
    fun getProducts(): Single<GetProductsResponse>
}