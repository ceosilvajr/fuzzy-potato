package com.ceosilvajr.network

import com.ceosilvajr.network.repository.MovieRepositoryImpl
import com.ceosilvajr.network.viewmodel.OnlineMovieViewModel
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author ceosilvajr@gmail.com
 */
object NetworkModule {

    fun load() = module {

        single { httpClient() }
        single { createRetrofit(get()) }
        single { createApiService(get()) }

        factory { MovieRepositoryImpl(get()) }
        viewModel { OnlineMovieViewModel(get()) }

    }

    private fun createApiService(retrofit: Retrofit): ApiEndpoint = retrofit.create(ApiEndpoint::class.java)

    private fun httpClient(): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.connectTimeout(Properties.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(Properties.READ_TIMEOUT, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(httpLoggingInterceptor)
        }
        return clientBuilder.build()
    }

    private fun createRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
            .baseUrl(Properties.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()

    private object Properties {
        const val BASE_URL = BuildConfig.BASE_URL
        const val READ_TIMEOUT = 60L
        const val CONNECTION_TIMEOUT = 60L
    }
}