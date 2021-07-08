package cz.koubicl.notino.remote.service

import com.squareup.moshi.Moshi

class NotinoServiceProvider(
    private val moshi: Moshi,
    private val notinoServiceFactory: NotinoServiceFactory
) {
    init {
        updateService()
    }

    lateinit var service: NotinoService
        private set

    private fun updateService() {
        service = notinoServiceFactory.makeNotinoService(
            moshi
        )
    }
}
