package com.daniel.githubapp.data.mapper

import com.daniel.githubapp.data.dto.DTORepositoryList
import com.daniel.githubapp.domain.entity.GithubRepository

class GithubRepositoryListMapper : BaseMapper<DTORepositoryList, List<GithubRepository>>() {

    override fun transform(entity: DTORepositoryList): List<GithubRepository> {
        val repositoryList = mutableListOf<GithubRepository>()
        entity.repositoriesList.map { repository ->
            repositoryList.add(GithubRepository(repository.name, repository.owner.name))
        }
        return repositoryList.toList()
    }
}