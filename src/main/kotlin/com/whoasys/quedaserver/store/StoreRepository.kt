package com.whoasys.quedaserver.store

import org.springframework.data.repository.CrudRepository

interface StoreRepository : CrudRepository<Store, Int> {

    fun findStoreById(id: Int): Store?
}
