package com.gorosoft.bookme.now.data.network

data class ServerException(
    val code: Int,
    override val message: String,
) : Exception()