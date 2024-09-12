package ru.translator.testproject.dto.response

import io.swagger.v3.oas.annotations.media.Schema
import ru.translator.testproject.output.entity.UserEntity
import kotlin.concurrent.thread

data class UserResponse(
    @Schema(description = "Идентификатор пользователя.")
    val id: Long,

    @Schema(description = "Признак мягкого удаления пользователя.")
    val isDeleted: Boolean,

    @Schema(description = "Электронная почта пользователя.")
    val email: String,
) {

    companion object {
        fun UserEntity.toUserResponse() = UserResponse(
            id = this.id,
            isDeleted = this.isDeleted,
            email = this.login,
        )
    }
}