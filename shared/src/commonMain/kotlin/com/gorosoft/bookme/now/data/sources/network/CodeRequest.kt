package com.gorosoft.bookme.now.data.sources.network

import kotlinx.serialization.Serializable

@Serializable
data class CodeRequest(
    val phone: String,
    val code: String,
)
