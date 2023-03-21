package com.whoasys.quedaserver.keyword

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/keyword")
class KeywordController(private val repository: KeywordRepository) {

    @PostMapping("/new")
    fun savePost(@RequestBody keyword: Keyword): Int? {

        repository.save(keyword)
        return keyword.id
    }
}