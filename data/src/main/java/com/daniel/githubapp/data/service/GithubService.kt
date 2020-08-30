package com.daniel.githubapp.data.service

import com.daniel.githubapp.data.dto.DTORepositoryList
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("search/repositories?q=language:Java&sort=stars")
    suspend fun loadRepositoryPageFromApi(@Query("page") page: Int): DTORepositoryList
}