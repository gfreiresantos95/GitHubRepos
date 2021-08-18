package br.com.githubrepos.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.githubrepos.databinding.ActivityMainBinding
import br.com.githubrepos.dto.RepositoryData
import br.com.githubrepos.view.adapter.RepositoriesListAdapter
import br.com.githubrepos.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var repositoriesListAdapter: RepositoriesListAdapter
    private var page = 1
    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        initRecycler()
        setListeners()
        setObservable()
        searchRepositories()
    }

    private fun initRecycler() {
        with(binding) {
            rvRepositoriesList.setHasFixedSize(true)
            rvRepositoriesList.isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(this@MainActivity)
            rvRepositoriesList.layoutManager = layoutManager
            repositoriesListAdapter = RepositoriesListAdapter(this@MainActivity)
            rvRepositoriesList.adapter = repositoriesListAdapter
        }
    }

    private fun setListeners() {
        with(binding) {
            nsParentView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->
                val viewBottom = nsParentView.getChildAt(nsParentView.childCount - 1).bottom
                val diff = viewBottom - (nsParentView.height + scrollY)

                if (diff == 0) {
                    if (!isLoading) {
                        searchRepositories()
                    }
                }
            })
        }
    }

    private fun setObservable() {
        mainActivityViewModel.getGitHubRepositories().observe(this, {
            isLoading = false

            if (page < it.totalCount) {
                page++
            }

            if (it.items.isNotEmpty()) {
                showList(it.items)
            } else {
                showError()
            }
        })
    }

    private fun searchRepositories() {
        isLoading = true
        binding.loadingProgress.visibility = View.VISIBLE
        mainActivityViewModel.searchGitHubRepositories(page)
    }

    private fun showList(items: ArrayList<RepositoryData>) {
        repositoriesListAdapter.add(items)
        binding.loadingProgress.visibility = View.GONE
    }

    private fun showError() {
        Toast.makeText(this@MainActivity, "Houve erro!", Toast.LENGTH_SHORT).show()
        binding.loadingProgress.visibility = View.GONE
    }
}