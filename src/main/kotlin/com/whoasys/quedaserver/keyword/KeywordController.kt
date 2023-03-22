package com.whoasys.quedaserver.keyword

import com.whoasys.quedaserver.post.Post
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/keyword")
class KeywordController(private val repository: KeywordRepository) {

    @PostMapping("/new")
    fun savePost(@RequestBody keyword: Keyword): Int? {

        repository.save(keyword)
        return keyword.id
    }

    @ResponseBody
    @GetMapping("/all")
    fun getAllKeywords(): List<Keyword>? = repository.findAllByOrderByValueDesc()
}