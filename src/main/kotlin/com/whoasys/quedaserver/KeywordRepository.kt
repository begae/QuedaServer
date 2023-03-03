package com.whoasys.quedaserver

import org.springframework.data.repository.CrudRepository
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

interface KeywordRepository : CrudRepository<Keyword, Int> {

}

@RestController
@RequestMapping("/api/keyword")
class KeywordController(private val repository: KeywordRepository) {

}
