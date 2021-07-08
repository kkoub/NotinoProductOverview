package cz.koubicl.notino.remote

import com.squareup.moshi.Moshi
import cz.koubicl.notino.remote.adapters.BooleanAdapter
import cz.koubicl.notino.remote.service.NotinoServiceFactory
import cz.koubicl.notino.remote.service.NotinoServiceProvider
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object RemoteKoinModule {

    val instance = module {

        single {
            Moshi.Builder()
                .add(Boolean::class.java, BooleanAdapter())
                .build() as Moshi
        }
        single { NotinoServiceProvider(get(), get()) }
        single { NotinoServiceFactory() }
        single { ProductsRemote(get()) }
    }

    fun start() {
        loadKoinModules(instance)
    }
}