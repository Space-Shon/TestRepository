package ru.translator.testproject.domain.service

import org.springframework.stereotype.Service
import ru.translator.testproject.dto.request.UserGetByParameterRequest
import ru.translator.testproject.output.entity.UserEntity
import ru.translator.testproject.output.service.UserServiceImpl

@Service
class UserDomainService(
    private val userService: UserServiceImpl
) {

    fun getAllUsers(requestParam: UserGetByParameterRequest): List<UserEntity> =
        userService.getAllBy(requestParam = requestParam)
}