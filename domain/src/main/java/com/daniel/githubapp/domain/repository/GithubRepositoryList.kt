package com.daniel.githubapp.domain.repository

import com.daniel.githubapp.domain.entity.GithubRepository
import kotlinx.coroutines.flow.Flow

interface GithubRepositoryList {
    suspend fun getRepositoryList(): Flow<List<GithubRepository>>
}