package com.manta.topmarket.ui

data class UiState<T>(
    val isLoading : Boolean = false,
    val cause : Throwable? = null,
    val value : T? = null
) {
    val isError: Boolean = cause != null

    fun getOrDefault(defaultValue : T): T {
        return value ?: defaultValue
    }

    companion object {
        fun <T> loading() = UiState<T>(isLoading = true)
        fun <T> success(value: T) = UiState(value = value)
        fun <T> error(cause : Throwable) = UiState<T>(cause = cause)
    }
}