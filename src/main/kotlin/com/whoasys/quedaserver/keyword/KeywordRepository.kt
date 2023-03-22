package com.whoasys.quedaserver.keyword

import org.springframework.data.repository.CrudRepository

interface KeywordRepository : CrudRepository<Keyword, Int> {

    fun findAllByOrderByValueDesc(): List<Keyword>?
}
