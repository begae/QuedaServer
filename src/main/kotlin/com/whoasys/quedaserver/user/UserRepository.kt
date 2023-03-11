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

    @Modifying
    @Query(value = "update user set is_manager=true, store_id=:storeId where id=:userId",
        nativeQuery = true)
    fun updateUserAsManager(userId: String, storeId: Int)
}