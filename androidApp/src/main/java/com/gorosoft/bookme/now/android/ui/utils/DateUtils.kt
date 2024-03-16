package com.gorosoft.bookme.now.android.ui.utils

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

object DateUtils {

    fun convertMillisToLocalDate(millis: Long?): LocalDate {
        return Instant
            .ofEpochMilli(millis ?: System.currentTimeMillis())
            .atZone(ZoneId.systemDefault())
            .toLocalDate()
    }

    fun dateToString(date: LocalDate?): String {
        if (date == null) return ""
        val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.getDefault())
        return date.format(dateFormatter)
    }
}
