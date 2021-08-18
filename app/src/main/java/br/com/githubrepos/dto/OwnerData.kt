package br.com.githubrepos.dto


import com.google.gson.annotations.SerializedName

data class OwnerData(
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String
)