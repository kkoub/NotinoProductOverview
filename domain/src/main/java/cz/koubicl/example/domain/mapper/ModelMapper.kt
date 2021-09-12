package cz.koubicl.example.domain.mapper

interface ModelMapper<in RESPONSE, out MODEL> {

    fun fromResponse(response: RESPONSE): MODEL
}