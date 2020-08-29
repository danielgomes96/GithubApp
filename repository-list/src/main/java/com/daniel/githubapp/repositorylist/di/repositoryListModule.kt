package com.daniel.githubapp.repositorylist.di

import com.daniel.githubapp.repositorylist.RepositoryListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryListModule = module {
    viewModel {
        RepositoryListViewModel(get())
    }
}