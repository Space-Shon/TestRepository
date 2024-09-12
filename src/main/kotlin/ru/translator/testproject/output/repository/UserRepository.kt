package ru.translator.testproject.output.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import ru.translator.testproject.output.entity.UserEntity

interface UserRepository : JpaRepository<UserEntity, Long> {

    @Query("""
        select u from UserEntity u
        where (:isDeleted is null or u.isDeleted = :isDeleted)
    """)
    fun getAllBy(isDeleted: Boolean?): List<UserEntity>
}