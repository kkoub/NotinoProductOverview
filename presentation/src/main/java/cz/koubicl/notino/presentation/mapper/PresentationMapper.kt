package cz.koubicl.notino.presentation.mapper

interface PresentationMapper<out PRESENTATION, in DOMAIN> {

    fun mapToPresentation(type: DOMAIN): PRESENTATION

}