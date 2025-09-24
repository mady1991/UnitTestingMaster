package com.android.mockito_unit_testing.mock

data class Person(
    val id: Int,
    val name: String,
    val email: String,
    val password: String
)

enum class LOGIN_STATUS{
    INVALID_PERSON,
    INVALID_PASSWORD,
    UNKNOWN_ERROR,
    SUCCESS
}