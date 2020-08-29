package com.daniel.githubapp.data.di

import com.daniel.githubapp.data.repository.RepositoryListRepositoryImpl
import com.daniel.githubapp.domain.repository.GithubRepositoryList
import org.koin.dsl.module

val repositoryModule = module {
    factory {
        RepositoryListRepositoryImpl(get()) as GithubRepositoryList
    }
}