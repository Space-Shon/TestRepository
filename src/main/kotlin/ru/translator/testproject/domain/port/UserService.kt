package ru.translator.testproject.domain.port

import ru.translator.testproject.dto.request.UserGetByParameterRequest
import ru.translator.testproject.output.entity.UserEntity

interface UserService {

    fun getAllBy(requestParam: UserGetByParameterRequest): List<UserEntity>
}