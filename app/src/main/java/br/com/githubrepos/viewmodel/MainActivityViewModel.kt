package br.com.githubrepos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.githubrepos.dto.GitHubRepositoryResponse
import br.com.githubrepos.repository.GitHubRepository

class MainActivityViewModel : ViewModel() {

    private val gitHubRepository = GitHubRepository()

    fun searchGitHubRepositories(pageNumber: Int) {
        gitHubRepository.getGitHubRepositories(pageNumber)
    }

    fun getGitHubRepositories(): LiveData<GitHubRepositoryResponse> {
        return gitHubRepository.repositories
    }
}