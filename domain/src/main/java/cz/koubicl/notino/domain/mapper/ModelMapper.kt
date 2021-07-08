package cz.koubicl.notino.domain.mapper

interface ModelMapper<RESPONSE, MODEL> {

    fun fromResponse(response: RESPONSE): MODEL
}