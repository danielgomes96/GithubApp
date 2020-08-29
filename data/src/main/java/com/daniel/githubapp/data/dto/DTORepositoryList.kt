package com.daniel.githubapp.data.dto

import com.google.gson.annotations.SerializedName

data class DTORepositoryList(
    @SerializedName("items")
    val repositoriesList: List<DTORepository>
)