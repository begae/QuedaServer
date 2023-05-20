package com.whoasys.quedaserver.post

import com.whoasys.quedaserver.user.User
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class Post (
    var title: String,
    @ManyToOne val author: User,
    var content: String,
    val isPromo: Boolean,
    val promoStart: String?,
    val promoEnd: String?,
    var attached0: String? = null,
    var attached1: String? = null,
    var attached2: String? = null,
    @Id @GeneratedValue var id: Int? = null,
    val addedMillis: Long = System.currentTimeMillis()
)