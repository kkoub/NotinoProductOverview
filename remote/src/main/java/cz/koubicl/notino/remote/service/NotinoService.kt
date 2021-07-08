package cz.koubicl.notino.remote.service

import cz.koubicl.notino.remote.model.GetProductsResponse
import io.reactivex.Single
import retrofit2.http.GET

interface NotinoService {
    @GET("michals92/notino-mobile-test/db")
    fun getProducts(): Single<GetProductsResponse>
}