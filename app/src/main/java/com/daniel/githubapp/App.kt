package com.daniel.githubapp

import android.app.Application
import com.daniel.githubapp.data.di.repositoryModule
import com.daniel.githubapp.data.di.retrofitModule
import com.daniel.githubapp.domain.di.domainModule
import com.daniel.githubapp.repositorylist.di.repositoryListModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    private fun initDI() {
        startKoin {
            androidContext(this@App)
            modules(listOf(
                repositoryListModule,
                domainModule,
                repositoryModule,
                retrofitModule)
            )
        }
    }
}