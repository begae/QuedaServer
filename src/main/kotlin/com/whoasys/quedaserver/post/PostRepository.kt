package com.whoasys.quedaserver.post

import com.whoasys.quedaserver.user.User
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional

@Transactional
interface PostRepository : CrudRepository<Post, Int> {

    fun findAllByAuthorIdOrderByAddedMillisDesc(author: String): List<Post>?

    fun findPostsByOrderByAddedMillisDesc(): List<Post>?

    @Query(value = "select from post where author=(select from user where latitude>=:lat-0.1 and " +
            "latitude<=:lat+0.1 and longitude>=:lng-0.1 and longitude<=:lng+0.1) order by added_millis desc", nativeQuery = true)
    fun findPostsNearby1000(lat: Double, lng: Double): List<Post>?

    fun findPostById(id: Int): Post?

    @Modifying
    @Query(value = "update post set attached:num=:key where id=:id", nativeQuery = true)
    fun attach(num: Int, id: Int, key: String)
}