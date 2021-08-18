package br.com.githubrepos.dto


import com.google.gson.annotations.SerializedName

data class RepositoryData(
    @SerializedName("forks")
    val forks: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("owner")
    val owner: OwnerData,
    @SerializedName("stargazers_count")
    val stargazersCount: Int,
)