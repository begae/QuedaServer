package com.whoasys.quedaserver.post

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional

@Transactional
interface PostRepository : CrudRepository<Post, Int> {

    fun findAllByAuthorIdOrderByAddedMillisDesc(author: String): List<Post>?

    fun findAllByOrderByAddedMillisDesc(): List<Post>?

    fun findPostById(id: Int): Post?

    fun findAllByIdIn(ids: List<Int>?): List<Post>?

    @Modifying
    @Query(value = "update post set attached:num=:key where id=:id", nativeQuery = true)
    fun attach(num: Int, id: Int, key: String)
}