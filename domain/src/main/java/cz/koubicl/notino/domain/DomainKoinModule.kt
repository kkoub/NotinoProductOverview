package cz.koubicl.notino.domain

import cz.koubicl.notino.domain.interactor.GetProductsInteractor
import cz.koubicl.notino.domain.mapper.ProductsMapper
import cz.koubicl.notino.domain.repository.ProductsRepository
import cz.koubicl.notino.remote.RemoteKoinModule
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