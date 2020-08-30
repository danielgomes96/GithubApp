package com.daniel.githubapp.data.repository

import com.daniel.githubapp.data.mapper.GithubRepositoryListMapper
import com.daniel.githubapp.data.service.GithubService
import com.daniel.githubapp.domain.entity.GithubRepository
import com.daniel.githubapp.domain.repository.GithubRepositoryList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryListRepositoryImpl(
    private val githubService: GithubService,
    private val githubRepositoryMapper: GithubRepositoryListMapper
) : GithubRepositoryList {

    override suspend fun getRepositoryList(): Flow<List<GithubRepository>> = flow {
        emit(
            githubRepositoryMapper.transform(
                githubService.loadRepositoryPageFromApi(1)
            )
        )
    }
}