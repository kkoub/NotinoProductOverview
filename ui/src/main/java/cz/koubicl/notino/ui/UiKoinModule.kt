package cz.koubicl.notino.ui

import cz.koubicl.notino.presentation.PresentationKoinModule
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