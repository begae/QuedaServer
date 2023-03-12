package com.whoasys.quedaserver.post

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional

@Transactional
interface PostRepository : CrudRepository<Post, Int> {

    fun findAllByAuthorIdOrderByAddedMillisDesc(author: String): List<Post>?

    @Query(value = "select from post order by added_millis desc", nativeQuery = true)
    fun findPostsNearby1000(lat: Double, lng: Double): List<Post>?

    fun findPostById(id: Int): Post?

    @Modifying
    @Query(value = "update post set attached:num=:key where id=:id", nativeQuery = true)
    fun attach(num: Int, id: Int, key: String)
}