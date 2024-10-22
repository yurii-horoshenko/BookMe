package com.gorosoft.bookme.now.data.sources.network.models.booking

import com.gorosoft.bookme.now.domain.models.BookingModel
import kotlinx.serialization.Serializable

@Serializable
data class BookingApi(
    val bookingId: String? = null,
    val placeId: String? = null,
    val dataTime: Long? = 0,
    val name: String? = null,
    val description: String? = null,
    val phone: String? = null,
    val address: String? = null,
    val website: String? = null,
)

fun BookingApi.toDomain(): BookingModel {
    return BookingModel(
        bookingId = bookingId ?: "",
        placeId = placeId ?: "",
        dataTime = dataTime ?: 0,
        name = name ?: "",
        description = description ?: "",
        phone = phone ?: "",
        address = address ?: "",
        website = website ?: "",
    )
}
