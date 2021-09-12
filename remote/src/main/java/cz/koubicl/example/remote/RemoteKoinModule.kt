package cz.koubicl.example.remote

import com.squareup.moshi.Moshi
import cz.koubicl.example.remote.adapters.BooleanAdapter
import cz.koubicl.example.remote.service.ExampleServiceFactory
import cz.koubicl.example.remote.service.ExampleServiceProvider
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object RemoteKoinModule {

    val instance = module {

        single {
            Moshi.Builder()
                .add(Boolean::class.java, BooleanAdapter())
                .build() as Moshi
        }
        single { ExampleServiceProvider(get(), get()) }
        single { ExampleServiceFactory() }
        single { ProductsRemote(get()) }
    }

    fun start() {
        loadKoinModules(instance)
    }
}