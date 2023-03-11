package com.whoasys.quedaserver.store

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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