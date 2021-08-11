package br.com.githubrepos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.githubrepos.dto.RepositoryData
import br.com.githubrepos.repository.GitHubRepository

class GitHubViewModel : ViewModel() {

    private val gitHubRepository = GitHubRepository()

    fun searchGitHubRepositories() {
        gitHubRepository.getGitHubRepositories()
    }

    fun getGitHubRepositories(): LiveData<List<RepositoryData>> {
        return gitHubRepository.repositories
    }
}