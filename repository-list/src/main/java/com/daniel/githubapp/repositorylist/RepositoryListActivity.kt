package com.daniel.githubapp.repositorylist

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.daniel.githubapp.commons.extension.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepositoryListActivity : AppCompatActivity() {

    private val rvRepositoryList by bind<RecyclerView>(R.id.activity_repository_list_rv_items)
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
        viewModel.repoList.observe(this, Observer {
            repositoryListAdapter.setupList(it)
        })
    }

    private fun requestData() {
        viewModel.getData()
    }

    private fun setupRecyclerView() {
        rvRepositoryList.adapter = repositoryListAdapter
    }
}