package com.gorosoft.bookme.now.Entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CodeRequest(
    val phone: String,
    val code: String
)