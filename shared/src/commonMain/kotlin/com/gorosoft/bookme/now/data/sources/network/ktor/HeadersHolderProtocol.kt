package com.gorosoft.bookme.now.data.sources.network.ktor

import io.ktor.http.HeadersBuilder

interface HeadersHolderProtocol {

    var headers: Map<String, String>

    fun addHeaders(builder: HeadersBuilder)

    fun clearHeaders()
}
