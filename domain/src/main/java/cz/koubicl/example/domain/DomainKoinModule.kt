package cz.koubicl.example.domain

import cz.koubicl.example.domain.interactor.GetProductsInteractor
import cz.koubicl.example.domain.mapper.ProductsMapper
import cz.koubicl.example.domain.repository.ProductsRepository
import cz.koubicl.example.remote.RemoteKoinModule
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object DomainKoinModule {

    val instance = module {
        factory { GetProductsInteractor(get()) }

        single { ProductsRepository(get(), get()) }
        single { ProductsMapper() }
    }

    fun start() {
        RemoteKoinModule.start()
        loadKoinModules(instance)
    }
}