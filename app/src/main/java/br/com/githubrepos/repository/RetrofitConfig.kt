package br.com.githubrepos.repository

import br.com.githubrepos.repository.remote.GitHubService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {

    private const val BASE_URL = "https://api.github.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getGitHubService(): GitHubService = retrofit.create(GitHubService::class.java)
}