package com.gorosoft.bookme.now.data.network.model.request

import kotlinx.serialization.Serializable

@Serializable
data class CodeRequest(
    val phone: String,
    val code: String
)