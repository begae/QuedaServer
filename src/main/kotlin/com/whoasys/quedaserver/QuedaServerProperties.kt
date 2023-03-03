package com.whoasys.quedaserver

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("queda")
data class QuedaServerProperties(var title: String?, val banner: Banner?) {
    data class Banner(val title: String? = null, val content: String?)
}