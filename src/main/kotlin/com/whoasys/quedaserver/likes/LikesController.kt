package com.whoasys.quedaserver.likes

import com.whoasys.quedaserver.keyword.Keyword
import com.whoasys.quedaserver.post.Post
import com.whoasys.quedaserver.post.PostRepository
import com.whoasys.quedaserver.store.Store
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/likes")
class LikesController(private val repository: LikesRepository,
    private val postRepo: PostRepository) {

    @PostMapping("/scrap")
    fun scrap(userId: String, postId: Int): Boolean {

        return if (repository.checkScrap(userId, postId) != null) {
            false
        } else {
            val new = Likes(userId, postId, null, null)
            repository.save(new)
            true
        }
    }

    @PostMapping("/follow")
    fun follow(userId: String, storeId: Int): Boolean {

        return if (repository.checkFollow(userId, storeId) != null) {
            false
        } else {
            val new = Likes(userId, null, storeId, null)
            repository.save(new)
            true
        }
    }

    @PostMapping("/select")
    fun selectKeyword(userId: String, keywordId: Int): Boolean {

        return if (repository.checkKeyword(userId, keywordId) != null) {
            false
        } else {
            val new = Likes(userId, null, null, keywordId)
            repository.save(new)
            true
        }
    }

    @GetMapping("/posts")
    fun getScraps(userId: String): List<Post>? {

        val ids = repository.getScraps(userId)
        return postRepo.findAllByIdIn(ids)
    }

    @GetMapping("/stores")
    fun getFollowing(userId: String): List<Store>? = repository.getFollowing(userId)

    @GetMapping("/keywords")
    fun getKeywords(userId: String): List<Keyword>? = repository.getKeywords(userId)
}