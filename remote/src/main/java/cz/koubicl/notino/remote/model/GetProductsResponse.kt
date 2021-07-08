package cz.koubicl.notino.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import cz.koubicl.notino.remote.service.model.AmountValueResponse

@JsonClass(generateAdapter = true)
data class GetProductsResponse(
    @Json(name = "vpProductByIds")
    val products: List<ProductResponse> = listOf()
) {

    @JsonClass(generateAdapter = true)
    data class ProductResponse(
        @Json(name = "id")
        val id: String,
        @Json(name = "productId")
        val productId: Int,
        @Json(name = "masterId")
        val masterId: Int,
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
        @Json(name = "attributes")
        val attributes: ProductAttributesResponse,
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
        data class ProductAttributesResponse(
            @Json(name = "Master")
            val master: Boolean,
            @Json(name = "EAN")
            val ean: String,
            @Json(name = "PackageSize")
            val packageSize: ProductPackageSizeResponse
        ) {

            @JsonClass(generateAdapter = true)
            data class ProductPackageSizeResponse(
                @Json(name = "height")
                val height: Int,
                @Json(name = "width")
                val width: Int,
                @Json(name = "depth")
                val depth: Int
            )
        }

        @JsonClass(generateAdapter = true)
        data class ProductAvailabilityResponse(
            @Json(name = "code")
            val code: String,
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