package br.com.githubrepos.repository.remote

import br.com.githubrepos.dto.GitHubRepositoryResponse
import retrofit2.Call
import retrofit2.http.GET

interface GitHubService {

    @GET("search/repositories?q=language:kotlin&sort=stars")
    fun getGitHubRepositories(): Call<GitHubRepositoryResponse>
}