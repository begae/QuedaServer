package com.whoasys.quedaserver.likes

import com.whoasys.quedaserver.keyword.Keyword
import com.whoasys.quedaserver.post.Post
import com.whoasys.quedaserver.store.Store
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface LikesRepository : CrudRepository<Likes, Int> {

    @Query(value = "select all from post where id = (select post_id from likes " +
            "where user_id=:userId and post_id is not null)", nativeQuery = true)
    fun getScraps(userId: String): List<Post>?

    @Query(value = "select all from store where id = (select store_id from likes " +
            "where user_id=:userId and store_id is not null)", nativeQuery = true)
    fun getFollowing(userId: String): List<Store>?

    @Query(value = "select all from keyword where id = (select keyword_id from likes " +
            "where user_id=:userId and keyword_id is not null)", nativeQuery = true)
    fun getKeywords(userId: String): List<Keyword>?
}