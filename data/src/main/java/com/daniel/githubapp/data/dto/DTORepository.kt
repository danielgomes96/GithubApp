package com.daniel.githubapp.data.dto

data class DTORepository(
    val id: Int,
    val name: String,
    val owner: DTOOwner,
    val description: String
)