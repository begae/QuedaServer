package com.whoasys.quedaserver

import com.whoasys.quedaserver.keyword.KeywordRepository
import com.whoasys.quedaserver.likes.LikesRepository
import com.whoasys.quedaserver.post.PostRepository
import com.whoasys.quedaserver.store.StoreRepository
import com.whoasys.quedaserver.user.UserRepository
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
        keywordRepository: KeywordRepository,
        likesRepository: LikesRepository

    ) = ApplicationRunner {

    }
}