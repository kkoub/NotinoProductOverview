package cz.koubicl.example.ui

import cz.koubicl.example.presentation.PresentationKoinModule
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object UiKoinModule {

    val instance = module {

    }

    fun start() {
        PresentationKoinModule.start()
        loadKoinModules(instance)
    }
}