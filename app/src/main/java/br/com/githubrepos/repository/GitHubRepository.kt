package br.com.githubrepos.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import br.com.githubrepos.dto.GitHubRepositoryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitHubRepository {

    private val gitHubService = RetrofitConfig.getGitHubService()
    var repositories = MutableLiveData<GitHubRepositoryResponse>()

    fun getGitHubRepositories(pageNumber: Int) {
        val call = gitHubService.getGitHubRepositories(pageNumber)

        call.enqueue(object : Callback<GitHubRepositoryResponse> {
            override fun onResponse(
                call: Call<GitHubRepositoryResponse>,
                response: Response<GitHubRepositoryResponse>
            ) {
                Log.i("MainRepository", response.message())
                if (response.isSuccessful) {
                    repositories.value = response.body()
                }
            }

            override fun onFailure(call: Call<GitHubRepositoryResponse>, t: Throwable) {
                Log.i("MainRepository", t.message.toString())
            }

        })
    }
}