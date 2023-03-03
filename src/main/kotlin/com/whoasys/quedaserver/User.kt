package com.whoasys.quedaserver

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class User(
    @Id var id: String,
    var pw: String,
    var name: String,
    var email: String,
    var isManager: Boolean = false,
    var storeId: Int? = null
)