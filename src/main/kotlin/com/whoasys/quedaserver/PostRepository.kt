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
    @Query(value = "update post set attached:num=:key where id=:id", nativeQuery = true)
    fun attach(num: Int, id: Int, key: String)
}

@RestController
@RequestMapping("/post")
class PostController(private val repository: PostRepository) {

    @PostMapping("/new")
    fun savePost(@RequestBody post: Post): Int? {

        repository.save(post)
        return post.id
    }

    @PostMapping("/attach")
    fun attach(num: Int, id: Int, key: String) = repository.attach(num, id, key)

    @ResponseBody
    @GetMapping("/by")
    fun getAllPostsBy(author: String) = repository.findAllByAuthorIdOrderByAddedMillisDesc(author)

    @GetMapping("/id")
    fun getOnePost(id: Int): Post? = repository.findPostById(id)
}