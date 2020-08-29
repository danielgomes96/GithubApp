package com.daniel.githubapp.domain.usecase

import com.daniel.githubapp.domain.entity.GithubRepository
import com.daniel.githubapp.domain.repository.GithubRepositoryList
import kotlinx.coroutines.flow.Flow

class GetRepositoryListUseCaseImpl(
    private val githubRepositoryList: GithubRepositoryList
) : GetRepositoryListUseCase {
    override suspend fun execute(): Flow<List<GithubRepository>> {
        return githubRepositoryList.getRepositoryList()
    }
}