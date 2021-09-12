package cz.koubicl.example.presentation

import cz.koubicl.example.domain.DomainKoinModule
import cz.koubicl.example.presentation.mapper.ProductItemsMapper
import cz.koubicl.example.presentation.viewmodel.ExampleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object PresentationKoinModule {

    val instance = module {
        viewModel { ExampleViewModel(get(), get()) }

        single { ProductItemsMapper() }
    }

    fun start() {
        DomainKoinModule.start()
        loadKoinModules(instance)
    }
}