package com.daniel.githubapp.repositorylist

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepositoryListActivity : AppCompatActivity() {

    private val viewModel by viewModel<RepositoryListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_list)
        viewModel.getData()
        viewModel.repoList.observe(this, Observer {
            Log.e("RepoList:", it.toString())
        })
    }
}