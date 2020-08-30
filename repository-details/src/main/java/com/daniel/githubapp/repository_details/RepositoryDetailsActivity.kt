package com.daniel.githubapp.repository_details

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.daniel.githubapp.commons.Consts
import com.daniel.githubapp.commons.extension.bind
import com.daniel.githubapp.domain.entity.GithubRepository

class RepositoryDetailsActivity : AppCompatActivity() {

    private val tvRepoName by bind<TextView>(R.id.activity_repository_details_tv_name)
    private val tvOwnerName by bind<TextView>(R.id.activity_repository_details_tv_ownername)
    private val tvDescription by bind<TextView>(R.id.activity_repository_details_tv_description)
    private val imAvatar by bind<TextView>(R.id.activity_repository_details_im_avatar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_details)
        setupToolbar()
        val githubRepository =
            intent.getSerializableExtra(Consts.KEY_INTENT_REPOSITORY) as GithubRepository
        setupData(githubRepository)
    }

    private fun setupToolbar() {
        supportActionBar?.apply {
            title = getString(R.string.repository_details_title_toolbar)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupData(githubRepository: GithubRepository) = with(githubRepository) {
        tvRepoName.text = name
        tvOwnerName.text = ownerName
        tvDescription.text = description
    }
}