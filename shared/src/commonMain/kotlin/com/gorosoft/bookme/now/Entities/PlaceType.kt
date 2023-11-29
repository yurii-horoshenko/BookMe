package com.gorosoft.bookme.now.Entities

import kotlinx.serialization.Serializable

@Serializable
enum class PLACETYPE(val text: String) {
    BARBER("barber"),
    CLINIC("clinic")
}