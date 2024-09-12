package ru.translator.testproject.dto.request

import io.swagger.v3.oas.annotations.media.Schema

data class UserGetByParameterRequest(
    @field:Schema(description = "Is deleted user", implementation = Boolean::class)
    val isDeleted: Boolean?,
)