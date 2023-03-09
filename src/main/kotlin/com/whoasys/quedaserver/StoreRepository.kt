package com.whoasys.quedaserver

import org.springframework.data.repository.CrudRepository
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

interface StoreRepository : CrudRepository<Store, Int> {

    fun findStoreById(id: Int): Store?
}

@RestController
@RequestMapping("/store")
class StoreController(private val repository: StoreRepository) {

    @RequestMapping("/register")
    fun register(@RequestBody store: Store): Int? {
        repository.save(store)
        return store.id
    }

    @RequestMapping("/id")
    fun getOneStore(id: Int): Store? = repository.findStoreById(id)
}