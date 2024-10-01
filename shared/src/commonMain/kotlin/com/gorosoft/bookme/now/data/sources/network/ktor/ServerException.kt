package com.gorosoft.bookme.now.data.sources.network.ktor

data class ServerException(
    val code: Int,
    override val message: String,
) : Exception()