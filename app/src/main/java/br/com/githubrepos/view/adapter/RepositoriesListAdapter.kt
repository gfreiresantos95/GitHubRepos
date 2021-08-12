package br.com.githubrepos.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.githubrepos.R
import br.com.githubrepos.databinding.RepositoryListItemBinding
import br.com.githubrepos.dto.RepositoryData
import com.bumptech.glide.Glide

class RepositoriesListAdapter(private var context: Context) :
    RecyclerView.Adapter<RepositoriesListAdapter.RepositoriesListViewHolder>() {

    private val repositoriesList = ArrayList<RepositoryData>()

    inner class RepositoriesListViewHolder(private val binding: RepositoryListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(repository: RepositoryData) {
            with(binding) {
                Glide.with(context)
                    .load(repository.owner.avatarUrl)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(ivRepoOwnerAvatar)

                repoName.text = repository.name
                repoOwner.text = repository.owner.login
                repoForksCount.text = repository.forks.toString()
                repoStarsCount.text = repository.stargazersCount.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesListViewHolder =
        RepositoriesListViewHolder(
            RepositoryListItemBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RepositoriesListViewHolder, position: Int) {
        val repository = repositoriesList[position]
        holder.bind(repository)
    }

    override fun getItemCount(): Int = repositoriesList.size

    fun add(repositories: ArrayList<RepositoryData>) {
        repositoriesList.addAll(repositories)
        notifyDataSetChanged()
    }
}