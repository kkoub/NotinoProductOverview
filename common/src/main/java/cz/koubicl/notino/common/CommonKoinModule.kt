package cz.koubicl.notino.common

import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object CommonKoinModule {

    val instance = module {

    }

    fun start() {
        loadKoinModules(instance)
    }
}