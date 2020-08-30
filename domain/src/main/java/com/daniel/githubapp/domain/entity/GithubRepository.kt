package com.daniel.githubapp.domain.entity

import java.io.Serializable

data class GithubRepository(
    val name: String,
    val ownerName: String,
    val description: String
) : Serializable