package ru.translator.testproject.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springdoc.core.annotations.ParameterObject
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.translator.testproject.domain.service.UserDomainService
import ru.translator.testproject.dto.request.UserGetByParameterRequest
import ru.translator.testproject.dto.response.UserResponse
import ru.translator.testproject.dto.response.UserResponse.Companion.toUserResponse

@RestController
@RequestMapping("/test")
@Tag(name = "Test")
class UserController(
    private val userDomainService: UserDomainService
) {

    @GetMapping
    @Operation(summary = "Get all users")
    fun getAllUsers(
        @ParameterObject requestParam: UserGetByParameterRequest,
    ): ResponseEntity<List<UserResponse>> = ResponseEntity.ok(
        userDomainService.getAllUsers(requestParam = requestParam).map { it.toUserResponse() }
    )
}