package com.whoasys.quedaserver.likes

import jakarta.persistence.Entity
import jakarta.persistence.Id
import javax.annotation.processing.Generated

@Entity
class Likes (
    val userId: String,
    val postId: Int?,
    val storeId: Int?,
    val keywordId: Int?,
    @Id @GeneratedValue var id: Int? = null
)