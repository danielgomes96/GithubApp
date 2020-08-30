package com.daniel.githubapp.domain.entity

sealed class NetworkViewState<T>() {
    class Loading<T>() : NetworkViewState<T>()
    class Success<T>(val data: T) : NetworkViewState<T>()
    class Error<T>() : NetworkViewState<T>()
}