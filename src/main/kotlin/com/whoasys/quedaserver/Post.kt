package com.whoasys.quedaserver

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class Post (
    val title: String,
    @ManyToOne val author: User,
    var content: String,
    val isPromo: Boolean,
    val promoStart: String?,
    val promoEnd: String?,
    val attached: String? = null,
    @Id @GeneratedValue var id: Int? = null,
    val addedMillis: Long = System.currentTimeMillis()
)