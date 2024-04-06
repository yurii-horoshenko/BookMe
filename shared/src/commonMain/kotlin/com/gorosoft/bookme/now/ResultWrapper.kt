package com.gorosoft.bookme.now

import com.gorosoft.bookme.now.data.network.ServerException
import com.gorosoft.bookme.now.data.network.model.response.DataResponse

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    sealed class Error(val msg: String) : ResultWrapper<Nothing>() {
        data class ServerHttpError(val httpCode: Int, val message: String) : Error(message)
        data class CustomError(val error: String) : Error(error)
        data class UnknownError(val message: String) : Error(message)
    }
}

suspend fun <T> safeCall(call: suspend () -> T): ResultWrapper<T> {
    return try {
        ResultWrapper.Success(call.invoke())
    } catch (e: ServerException) {
        ResultWrapper.Error.ServerHttpError(e.code, e.message)
    } catch (e: Exception) {
        ResultWrapper.Error.UnknownError(e.message ?: "Unknown error")
    }
}

suspend fun <T> safeDataResponseCall(call: suspend () -> DataResponse<T>): ResultWrapper<T> {
    return try {
        val body = call.invoke()
        when {
            body.success == true -> ResultWrapper.Success(body.data)
            else -> ResultWrapper.Error.CustomError(body.error ?: "Unknown error")
        }
    } catch (e: ServerException) {
        ResultWrapper.Error.ServerHttpError(e.code, e.message)
    } catch (e: Exception) {
        ResultWrapper.Error.UnknownError(e.message ?: "Unknown error")
    }
}

inline fun <T, R> ResultWrapper<T>.map(mapper: (T) -> R): ResultWrapper<R> {
    return when (this) {
        is ResultWrapper.Success -> ResultWrapper.Success(mapper(value))
        is ResultWrapper.Error -> this
    }
}

inline fun <T> ResultWrapper<T>.onSuccess(action: (T) -> Unit): ResultWrapper<T> {
    if (this is ResultWrapper.Success) action(value)
    return this
}

inline fun <T> ResultWrapper<T>.onError(action: (ResultWrapper.Error) -> Unit): ResultWrapper<T> {
    if (this is ResultWrapper.Error) action(this)
    return this
}