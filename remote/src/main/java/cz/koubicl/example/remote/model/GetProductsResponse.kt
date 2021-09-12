package cz.koubicl.example.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import cz.koubicl.example.remote.service.model.AmountValueResponse

@JsonClass(generateAdapter = true)
data class GetProductsResponse(
    @Json(name = "products")
    val products: List<ProductResponse> = listOf()
) {

    @JsonClass(generateAdapter = true)
    data class ProductResponse(
        @Json(name = "id")
        val id: Int,
        @Json(name = "price")
        val price: AmountValueResponse,
        @Json(name = "name")
        val name: String,
        @Json(name = "brand")
        val brand: ProductBrandResponse,
        @Json(name = "annotation")
        val annotation: String,
        @Json(name = "orderUnit")
        val orderUnit: String,
        @Json(name = "imageUrl")
        val imageUrl: String,
        @Json(name = "stockAvailability")
        val stockAvailability: ProductAvailabilityResponse,
        @Json(name = "reviewSummary")
        val reviewSummary: ProductRatingResponse
    ) {
        @JsonClass(generateAdapter = true)
        data class ProductBrandResponse(
            @Json(name = "id")
            val id: String,
            @Json(name = "name")
            val name: String
        )

        @JsonClass(generateAdapter = true)
        data class ProductAvailabilityResponse(
            @Json(name = "availability")
            val available: Boolean = false,
            @Json(name = "count")
            val count: Int?
        )

        @JsonClass(generateAdapter = true)
        data class ProductRatingResponse(
            @Json(name = "score")
            val score: Int
        )
    }
}