package com.daniel.githubapp.repositorylist

import androidx.lifecycle.MutableLiveData
import com.daniel.githubapp.commons.base.BaseViewModel
import com.daniel.githubapp.domain.entity.GithubRepository
import com.daniel.githubapp.domain.entity.NetworkViewState
import com.daniel.githubapp.domain.usecase.GetRepositoryListUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RepositoryListViewModel(
    private val getRepositoryListUseCase: GetRepositoryListUseCase
) : BaseViewModel() {

    val repoList: MutableLiveData<NetworkViewState<List<GithubRepository>>> get() = _repoList
    private val _repoList: MutableLiveData<NetworkViewState<List<GithubRepository>>> = MutableLiveData()

    fun getData() {
        _repoList.postValue(NetworkViewState.Loading())
        launch {
            getRepositoryListUseCase.execute()
                .catch {
                    _repoList.postValue(NetworkViewState.Error())
                }
                .collect { githubRepositoryList ->
                    _repoList.postValue(NetworkViewState.Success(githubRepositoryList))
                }
        }
    }
}