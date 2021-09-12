package cz.koubicl.example.remote.service.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class AmountValueResponse(
    @Json(name = "value")
    val value: Int,
    @Json(name = "currency")
    val currency: String
)