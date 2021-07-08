package cz.koubicl.notino.remote.service

import android.util.Log
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class NotinoServiceFactory {

    fun makeNotinoService(moshi: Moshi): NotinoService {
        return makeService(makeOkHttpClient(), moshi).create(NotinoService::class.java)
    }

    private fun makeService(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://my-json-server.typicode.com/")
        return retrofit.build()
    }

    private fun makeOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor { message ->
            Log.d("OkHttp", message)
        }
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val builder = OkHttpClient.Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .followRedirects(false)
        return builder.build()
    }
}