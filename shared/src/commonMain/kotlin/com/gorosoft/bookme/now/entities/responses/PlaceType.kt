package com.gorosoft.bookme.now.entities.responses

import kotlinx.serialization.Serializable

@Serializable
enum class PLACETYPE(val text: String) {
    BARBER("barber"),
    CLINIC("clinic")
}