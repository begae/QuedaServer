package com.whoasys.quedaserver

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QuedaServerConfiguration {

    @Bean
    fun databaseInitializer(

        userRepository: UserRepository,
        postRepository: PostRepository,
        storeRepository: StoreRepository,
        keywordRepository: KeywordRepository

    ) = ApplicationRunner {

    }
}