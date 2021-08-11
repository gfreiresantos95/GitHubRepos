package br.com.githubrepos.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import br.com.githubrepos.dto.GitHubRepositoryResponse
import br.com.githubrepos.dto.RepositoryData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitHubRepository {

    private val gitHubService = RetrofitConfig.getGitHubService()
    var repositories = MutableLiveData<List<RepositoryData>>()

    fun getGitHubRepositories() {
        val call = gitHubService.getGitHubRepositories()

        call.enqueue(object : Callback<GitHubRepositoryResponse> {
            override fun onResponse(
                call: Call<GitHubRepositoryResponse>,
                response: Response<GitHubRepositoryResponse>
            ) {
                Log.i("MainRepository", response.message())
                if (response.isSuccessful) {
                    repositories.value = response.body()?.items
                }
            }

            override fun onFailure(call: Call<GitHubRepositoryResponse>, t: Throwable) {
                Log.i("MainRepository", t.message.toString())
            }

        })
    }
}