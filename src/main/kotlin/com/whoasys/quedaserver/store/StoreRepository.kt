package com.whoasys.quedaserver.store

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface StoreRepository : CrudRepository<Store, Int> {

    fun findStoreById(id: Int): Store?

    @Query("select * from store where profile_pic is not null", nativeQuery = true)
    fun temporary(): List<Store>?
}
