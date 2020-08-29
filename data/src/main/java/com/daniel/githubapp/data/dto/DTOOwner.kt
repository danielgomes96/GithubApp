package com.daniel.githubapp.data.dto

import com.google.gson.annotations.SerializedName

data class DTOOwner(
    @SerializedName("login")
    val name: String
)