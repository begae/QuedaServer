package com.whoasys.quedaserver.keyword

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/keyword")
class KeywordController(private val repository: KeywordRepository) {

}