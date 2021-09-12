package cz.koubicl.example.remote.service

import com.squareup.moshi.Moshi

class ExampleServiceProvider(
    private val moshi: Moshi,
    private val exampleServiceFactory: ExampleServiceFactory
) {
    init {
        updateService()
    }

    lateinit var service: ExampleService
        private set

    private fun updateService() {
        service = exampleServiceFactory.makeExampleService(
            moshi
        )
    }
}
