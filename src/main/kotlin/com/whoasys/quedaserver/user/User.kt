package com.whoasys.quedaserver.user

import com.whoasys.quedaserver.store.Store
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class User(
    @Id var id: String,
    var pw: String,
    var name: String,
    var email: String,
    var latitude: Double? = null,
    var longitude: Double? = null,
    var isManager: Boolean = false,
    @ManyToOne var store: Store? = null
)