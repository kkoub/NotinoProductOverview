package cz.koubicl.notino.presentation

import cz.koubicl.notino.domain.DomainKoinModule
import cz.koubicl.notino.presentation.mapper.ProductItemsMapper
import cz.koubicl.notino.presentation.viewmodel.NotinoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object PresentationKoinModule {

    val instance = module {
        viewModel { NotinoViewModel(get(), get()) }

        single { ProductItemsMapper() }
    }

    fun start() {
        DomainKoinModule.start()
        loadKoinModules(instance)
    }
}