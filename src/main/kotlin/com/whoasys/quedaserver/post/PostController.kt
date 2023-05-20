package com.whoasys.quedaserver.post

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
    fun getAllPostsNearby(userId: String): List<Post>? = repository.findAllByOrderByAddedMillisDesc()

    @PostMapping("/attach")
    fun attach(num: Int, id: Int, key: String) = repository.attach(num, id, key)

    @ResponseBody
    @GetMapping("/by")
    fun getAllPostsBy(author: String) = repository.findAllByAuthorIdOrderByAddedMillisDesc(author)

    @GetMapping("/id")
    fun getOnePost(id: Int): Post? = repository.findPostById(id)


    //Post 수정 API -- 작성자 ID PW Email JOSN에 포함되어야 함..
    @PutMapping("/update/{id}")
    fun updatePost(@PathVariable id: Int, @RequestBody post: Post): ResponseEntity<String> {
        val existingPost = repository.findPostById(id)
        if (existingPost != null) {
            existingPost.title = post.title
            existingPost.content = post.content
            existingPost.attached0 = post.attached0
            existingPost.attached1 = post.attached0
            existingPost.attached2 = post.attached0
            repository.save(existingPost)
            return ResponseEntity.ok("Post with id $id has been updated.")
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post with id $id not found.")
    }

    // Post 삭제 API
    @DeleteMapping("/delete/{id}")
    fun deletePost(@PathVariable id: Int): String {
        val post = repository.findPostById(id)
        if (post != null) {
            repository.delete(post)
            return "Post with id $id has been deleted."
        }
        return "Post with id $id not found."
    }
}