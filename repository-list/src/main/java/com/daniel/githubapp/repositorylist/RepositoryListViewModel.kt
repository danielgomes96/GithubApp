package com.daniel.githubapp.repositorylist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.daniel.githubapp.commons.base.BaseViewModel
import com.daniel.githubapp.domain.entity.GithubRepository
import com.daniel.githubapp.domain.usecase.GetRepositoryListUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RepositoryListViewModel(
    private val getRepositoryListUseCase: GetRepositoryListUseCase
) : BaseViewModel() {

    val repoList: MutableLiveData<List<GithubRepository>> = MutableLiveData()

    fun getData() {
        launch {
            getRepositoryListUseCase.execute()
                .catch {
                    Log.e("Error:", this.toString())
                }
                .collect { githubRepositoryList ->
                    repoList.postValue(githubRepositoryList)
                }
        }

    }
}