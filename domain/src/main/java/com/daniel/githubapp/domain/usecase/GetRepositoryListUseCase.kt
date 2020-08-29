package com.daniel.githubapp.domain.usecase

import com.daniel.githubapp.domain.entity.GithubRepository
import kotlinx.coroutines.flow.Flow

interface GetRepositoryListUseCase {
    suspend fun execute(): Flow<List<GithubRepository>>
}
