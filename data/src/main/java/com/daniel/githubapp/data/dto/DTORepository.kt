package com.daniel.githubapp.data.dto

import com.google.gson.annotations.SerializedName

data class DTORepository(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)