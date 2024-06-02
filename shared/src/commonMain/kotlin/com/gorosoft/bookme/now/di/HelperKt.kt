package com.gorosoft.bookme.now.di

import com.gorosoft.bookme.now.data.network.headers_holder.HeadersHolderProtocol
import org.koin.core.context.startKoin

fun initKoin(
    headers: Map<String, String>,
) {
    startKoin {
        modules(sharedModule())
        val headersHolder: HeadersHolderProtocol = koin.get()
        headersHolder.headers = headers
    }
}
