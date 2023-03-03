package com.whoasys.quedaserver

import org.springframework.data.repository.CrudRepository
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

interface StoreRepository : CrudRepository<Store, Int> {

}

@RestController
@RequestMapping("/api/store")
class StoreController(private val repository: StoreRepository) {

    @RequestMapping("/register")
    fun register(@RequestBody store: Store): Int? {
        repository.save(store)
        return store.id
    }
}