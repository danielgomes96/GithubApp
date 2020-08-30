package com.daniel.githubapp.repositorylist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daniel.githubapp.domain.entity.GithubRepository

class RepositoryListAdapter(
    private val repositoryItemClick:(GithubRepository) -> Unit
) : RecyclerView.Adapter<RepositoryListAdapter.RepositoryViewHolder>() {

    private var repoList: ArrayList<GithubRepository> = arrayListOf()

    fun setupList(list: List<GithubRepository>) {
        repoList = ArrayList(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_repository_list,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount(): Int = repoList.size

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(repoList[position], repositoryItemClick)
    }

    inner class RepositoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val itemName = view.findViewById<TextView>(R.id.item_repository_list_name)
        private val itemOwnerName = view.findViewById<TextView>(R.id.item_repository_list_owner)

        fun bind(
            repository: GithubRepository,
            repositoryItemClick: (GithubRepository) -> Unit
        ) = with(repository) {
            itemName.text = name
            itemOwnerName.text = ownerName
            itemView.setOnClickListener {
                repositoryItemClick(this)
            }
        }
    }
}