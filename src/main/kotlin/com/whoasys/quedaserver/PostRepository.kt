package com.whoasys.quedaserver

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import java.io.File

@Transactional
interface PostRepository : CrudRepository<Post, Int> {

    fun findAllByAuthorIdOrderByAddedMillisDesc(author: String): Iterable<Post>?

    fun findPostById(id: Int): Post?

    @Modifying
    @Query(value = "update post set attached=:urls where id=:id", nativeQuery = true)
    fun attachFiles(id: Int, urls: String)
}

@RestController
@RequestMapping("/api/post")
class PostController(private val repository: PostRepository) {

    @PostMapping("/new")
    fun savePost(@RequestBody post: Post): Int? {

        repository.save(post)
        return post.id
    }

    @PostMapping("/attach")
    fun attachFiles(id: Int, urls: String): Int {

        repository.attachFiles(id, urls)
        return id
    }

    @GetMapping("/by/{author}")
    fun getAllPostsBy(author: String) = repository.findAllByAuthorIdOrderByAddedMillisDesc(author)

    @GetMapping("/{id}")
    fun getOnePost(@PathVariable id: String): Post? = repository.findPostById(id.toInt())
}