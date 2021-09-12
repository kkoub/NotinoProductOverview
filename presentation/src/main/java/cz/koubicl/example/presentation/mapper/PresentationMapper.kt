package cz.koubicl.example.presentation.mapper

interface PresentationMapper<out PRESENTATION, in DOMAIN> {

    fun mapToPresentation(type: DOMAIN): PRESENTATION

}