package com.whoasys.quedaserver.store

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.net.URL

@Entity
class Store (
    var name: String,
    var registration: String,
    var address: String,
    var latitude: Double,
    var longitude: Double,
    var phone: String,
    var openTime: String,
    var noticeId: Int? = null,
    var profilePic: URL? = null,
    var backgroundPic: URL? = null,
    var onPromotion: Boolean = false,
    @Id @GeneratedValue var id: Int? = null
)