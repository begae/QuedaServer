package com.whoasys.quedaserver.likes

import com.whoasys.quedaserver.keyword.Keyword
import com.whoasys.quedaserver.post.Post
import com.whoasys.quedaserver.store.Store
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface LikesRepository : CrudRepository<Likes, Int> {

@Query(value = "select id from likes where user_id=:userId and post_id=:postId", nativeQuery = true)
    fun checkScrap(userId: String, postId: Int): Int?

    @Query(value = "select id from likes where user_id=:userId and store_id=:storeId", nativeQuery = true)
    fun checkFollow(userId: String, storeId: Int): Int?

    @Query(value = "select id from likes where user_id=:userId and keyword_id=:keywordId", nativeQuery = true)
    fun checkKeyword(userId: String, keywordId: Int): Int?

    @Query(value = "select post_id from likes " +
            "where user_id=:userId and post_id is not null", nativeQuery = true)
    fun getScraps(userId: String): List<Int>?

    @Query(value = "select * from store where id = (select store_id from likes " +
            "where user_id=:userId and store_id is not null)", nativeQuery = true)
    fun getFollowing(userId: String): List<Store>?

    @Query(value = "select * from keyword where id = (select keyword_id from likes " +
            "where user_id=:userId and keyword_id is not null)", nativeQuery = true)
    fun getKeywords(userId: String): List<Keyword>?
}