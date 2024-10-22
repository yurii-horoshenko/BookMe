package com.gorosoft.bookme.now.domain.models

data class BookingModel(
    val bookingId: String,
    val placeId: String,
    val dataTime: Long,
    val name: String,
    val description: String,
    val phone: String,
    val address: String,
    val website: String,
)
