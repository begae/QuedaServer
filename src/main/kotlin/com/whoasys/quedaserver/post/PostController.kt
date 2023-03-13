package com.whoasys.quedaserver.post

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/post")
class PostController(private val repository: PostRepository) {

    @PostMapping("/new")
    fun savePost(@RequestBody post: Post): Int? {

        repository.save(post)
        return post.id
    }

    @ResponseBody
    @GetMapping("/nearby")
    fun getAllPostsNearby(): List<Post>? = repository.findAllByOrderByAddedMillisDesc()

    @PostMapping("/attach")
    fun attach(num: Int, id: Int, key: String) = repository.attach(num, id, key)

    @ResponseBody
    @GetMapping("/by")
    fun getAllPostsBy(author: String) = repository.findAllByAuthorIdOrderByAddedMillisDesc(author)

    @GetMapping("/id")
    fun getOnePost(id: Int): Post? = repository.findPostById(id)
}