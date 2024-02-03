package com.example.domain.usecase.model

data class ImageModel(
    val id: String,
    val description: String?,
    val urls: Urls,
    val user: User,
)
data class Urls (
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String
)
data class User (
    val name: String,
    val username: String
)