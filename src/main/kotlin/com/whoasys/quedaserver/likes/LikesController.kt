package com.whoasys.quedaserver.likes

import com.whoasys.quedaserver.keyword.Keyword
import com.whoasys.quedaserver.post.Post
import com.whoasys.quedaserver.store.Store
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/likes")
class LikesController(private val repository: LikesRepository) {

    @PostMapping("/scrap")
    fun scrap(userId: String, postId: Int): Boolean {

        val new = Likes(userId, postId, null, null)
        repository.save(new)
        return true
    }

    @PostMapping("/follow")
    fun follow(userId: String, storeId: Int): Boolean {

        val new = Likes(userId, null, storeId, null)
        repository.save(new)
        return true
    }

    @PostMapping("/select")
    fun selectKeyword(userId: String, keywordId: Int): Boolean {

        val new = Likes(userId, null, null, keywordId)
        repository.save(new)
        return true
    }

    @GetMapping("/posts")
    fun getScraps(userId: String): List<Post>? = repository.getScraps(userId)

    @GetMapping("/stores")
    fun getFollowing(userId: String): List<Store>? = repository.getFollowing(userId)

    @GetMapping("/keywords")
    fun getKeywords(userId: String): List<Keyword>? = repository.getKeywords(userId)
}