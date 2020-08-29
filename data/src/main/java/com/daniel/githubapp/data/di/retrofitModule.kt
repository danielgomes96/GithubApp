package com.daniel.githubapp.data.di

import com.daniel.githubapp.data.service.GithubService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {
    val BASE_URL = "https://api.github.com/"

    factory {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        if (BuildConfig.DEBUG) level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build()
            )
            .build()
    }
    single {
        get<Retrofit>().create(GithubService::class.java)
    }
}