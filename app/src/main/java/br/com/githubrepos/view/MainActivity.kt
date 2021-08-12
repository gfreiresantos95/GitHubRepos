package br.com.githubrepos.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.githubrepos.databinding.ActivityMainBinding
import br.com.githubrepos.view.adapter.RepositoriesListAdapter
import br.com.githubrepos.viewmodel.GitHubViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var gitHubViewModel: GitHubViewModel
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var repositoriesListAdapter: RepositoriesListAdapter
    private var page = 1
    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gitHubViewModel = ViewModelProvider(this).get(GitHubViewModel::class.java)

        initRecycler()
        setListeners()
        setObservable()
        searchRepositories()
    }

    private fun initRecycler() {
        with(binding) {
            rvRepositoriesList.setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            rvRepositoriesList.layoutManager = layoutManager
            repositoriesListAdapter = RepositoriesListAdapter(this@MainActivity)
            rvRepositoriesList.adapter = repositoriesListAdapter
        }
    }

    private fun setListeners() {
        binding.rvRepositoriesList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) {
                    val visibleItemCount = layoutManager.childCount
                    val firstVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition()
                    val totalItems = repositoriesListAdapter.itemCount

                    if (!isLoading) {
                        if ((visibleItemCount + firstVisibleItem) >= totalItems) {
                            searchRepositories()
                        }
                    }
                }

                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    private fun setObservable() {
        gitHubViewModel.getGitHubRepositories().observe(this, {
            isLoading = false

            if (page < it.totalCount) {
                page++
            }

            if (it.items.isNotEmpty()) {
                repositoriesListAdapter.add(it.items)
                binding.loadingProgress.visibility = View.GONE
            }
        })
    }

    private fun searchRepositories() {
        isLoading = true
        binding.loadingProgress.visibility = View.VISIBLE
        gitHubViewModel.searchGitHubRepositories(page)
    }
}