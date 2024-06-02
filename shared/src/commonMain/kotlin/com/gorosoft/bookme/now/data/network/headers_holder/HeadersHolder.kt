package com.gorosoft.bookme.now.data.network.headers_holder

import io.ktor.http.HeadersBuilder

class RuntimeHeadersHolder : HeadersHolderProtocol {

    override var headers: Map<String, String> = mutableMapOf()

    override fun addHeaders(builder: HeadersBuilder) {
        headers.forEach { (key, value) ->
            builder.append(key, value)
        }
    }

    override fun clearHeaders() {
        headers = mutableMapOf()
    }
}