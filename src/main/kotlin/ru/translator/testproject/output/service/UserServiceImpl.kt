package ru.translator.testproject.output.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.translator.testproject.domain.port.UserService
import ru.translator.testproject.dto.request.UserGetByParameterRequest
import ru.translator.testproject.output.entity.UserEntity
import ru.translator.testproject.output.repository.UserRepository

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
): UserService {

    @Transactional(readOnly = true)
    override fun getAllBy(requestParam: UserGetByParameterRequest): List<UserEntity> =
        userRepository.getAllBy(isDeleted = requestParam.deleted)
}