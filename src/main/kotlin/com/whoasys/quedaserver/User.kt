package com.whoasys.quedaserver

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class User(
    @Id var id: String,
    var pw: String,
    var name: String,
    var email: String,
    var isManager: Boolean = false,
    @ManyToOne var store: Store? = null
)