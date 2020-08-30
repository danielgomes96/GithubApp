package com.daniel.githubapp.repositorylist

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.daniel.githubapp.commons.extension.bind
import com.daniel.githubapp.commons.extension.gone
import com.daniel.githubapp.commons.extension.visible
import com.daniel.githubapp.domain.entity.GithubRepository
import com.daniel.githubapp.domain.entity.NetworkViewState
import com.daniel.githubapp.domain.entity.NetworkViewState.Success
import com.daniel.githubapp.domain.entity.NetworkViewState.Error
import com.daniel.githubapp.domain.entity.NetworkViewState.Loading
import com.daniel.githubapp.widget.ErrorView
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepositoryListActivity : AppCompatActivity() {

    private val rvRepositoryList by bind<RecyclerView>(R.id.activity_repository_list_rv_items)
    private val progressLoading by bind<ProgressBar>(R.id.activity_repository_list_progress)
    private val errorView by bind<ErrorView>(R.id.activity_repository_list_error_view)
    private val viewModel by viewModel<RepositoryListViewModel>()
    private val repositoryListAdapter by lazy {
        RepositoryListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_list)
        setupRecyclerView()
        requestData()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.repoList.observe(this, Observer (::handleViewState))
    }

    private fun handleViewState(viewState: NetworkViewState<List<GithubRepository>>?) {
        when (viewState) {
            is Loading -> displayLoading()
            is Success -> displayList(viewState.data)
            is Error -> displayError()
        }
    }

    private fun displayLoading() {
        errorView.gone()
        progressLoading.visible()
        rvRepositoryList.gone()
    }

    private fun displayList(data: List<GithubRepository>) {
        errorView.gone()
        progressLoading.gone()
        rvRepositoryList.visible()
        repositoryListAdapter.setupList(data)
    }

    private fun displayError() = with(errorView) {
        progressLoading.gone()
        rvRepositoryList.gone()
        visible()
        setImageId(R.drawable.ic_error)
        setTitleText(R.string.repository_list_error_title)
        setBodyText(R.string.repository_list_error_body)
        setButtonBehavior(R.string.repository_list_error_try_again) {
            requestData()
        }
    }

    private fun requestData() {
        viewModel.getData()
    }

    private fun setupRecyclerView() {
        rvRepositoryList.adapter = repositoryListAdapter
    }
}