package com.whoasys.quedaserver

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Keyword (
    @Id @GeneratedValue var id: Int? = null,
    val value: String
)