package com.gorosoft.bookme.now

import com.gorosoft.bookme.now.data.network.model.response.DataResponse

sealed class Response<out T> {
    data class Success<out T>(val data: T) : Response<T>()
    data class Error(val code: Int, val message: String) : Response<Nothing>()
    data class Failure(val exception: Throwable) : Response<Nothing>()
}

suspend fun <T> safeDataResponseCall(call: suspend () -> DataResponse<T>): Response<T> {
    return try {
        val body = call.invoke()

        when {
            body.success == true -> Response.Success(body.data)
            else -> Response.Error(code = 0, message = body.error ?: "")
        }
    } catch (e: Exception) {
        Response.Failure(e)
    }
}

inline fun <T, R> Response<T>.map(mapper: (T) -> R): Response<R> {
    return when (this) {
        is Response.Success -> Response.Success(mapper(data))
        is Response.Error -> this
        is Response.Failure -> this
    }
}

inline fun <T> Response<T>.onSuccess(result: (T) -> Unit): Response<T> {
    if (this is Response.Success) result(data)
    return this
}

inline fun <T> Response<T>.onFailure(result: (Response.Failure) -> Unit): Response<T> {
    if (this is Response.Failure) result(this)
    return this
}

inline fun <T> Response<T>.onError(result: (Response.Error) -> Unit): Response<T> {
    if (this is Response.Error) result(this)
    return this
}