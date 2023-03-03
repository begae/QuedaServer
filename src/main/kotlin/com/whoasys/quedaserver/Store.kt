package com.whoasys.quedaserver

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.net.URL

@Entity
class Store (
    val name: String,
    val registration: String,
    val managerId: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    var phone: String,
    var openTime: String,
    var noticeId: Int? = null,
    var profilePic: URL? = null,
    var backgroundPic: URL? = null,
    var onPromotion: Boolean = false,
    @Id @GeneratedValue var id: Int? = null,
)