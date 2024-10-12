package com.gorosoft.bookme.now.domain.models

data class ProfileTokenModel(
    val accessToken: String,
    val expirationDate: Long,
)
