package com.gorosoft.bookme.now

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform