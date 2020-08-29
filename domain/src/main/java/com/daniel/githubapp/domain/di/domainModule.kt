package com.daniel.githubapp.domain.di

import com.daniel.githubapp.domain.usecase.GetRepositoryListUseCase
import com.daniel.githubapp.domain.usecase.GetRepositoryListUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetRepositoryListUseCaseImpl(get()) as GetRepositoryListUseCase
    }
}