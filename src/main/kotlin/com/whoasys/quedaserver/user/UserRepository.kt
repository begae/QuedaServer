package com.whoasys.quedaserver.user

import com.whoasys.quedaserver.store.StoreRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@Transactional
interface UserRepository : CrudRepository<User, String> {

    fun findUserById(id: String): User?

    fun findUserByStoreId(storeId: Int): User?

    fun findUserByIdAndPw(id: String, pw: String): User?

    @Query(value = "select from user where latitude>=:lat-0.05 and latitude<=:lat+0.05 and" +
             " longitude>=:lng-0.1 and longitude<=:lng+0.1", nativeQuery = true)
    fun findUserNearby500(lat: Double, lng: Double): List<User>?

    @Modifying
    @Query(value = "update user set is_manager=true, store_id=:storeId where id=:userId",
        nativeQuery = true)
    fun updateUserAsManager(userId: String, storeId: Int)
}