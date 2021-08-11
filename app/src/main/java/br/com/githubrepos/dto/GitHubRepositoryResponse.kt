package br.com.githubrepos.dto


import com.google.gson.annotations.SerializedName

data class GitHubRepositoryResponse(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val items: List<RepositoryData>,
    @SerializedName("total_count")
    val totalCount: Int
)