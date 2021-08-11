package br.com.githubrepos.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import br.com.githubrepos.databinding.ActivityMainBinding
import br.com.githubrepos.viewmodel.GitHubViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var gitHubViewModel: GitHubViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gitHubViewModel = ViewModelProvider(this).get(GitHubViewModel::class.java)

        setObservable()
        gitHubViewModel.searchGitHubRepositories()
    }

    private fun setObservable() {
        gitHubViewModel.getGitHubRepositories().observe(this, {
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        })
    }
}