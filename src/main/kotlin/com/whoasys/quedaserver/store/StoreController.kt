package com.whoasys.quedaserver.store

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/store")
class StoreController(private val repository: StoreRepository) {

    @RequestMapping("/register")
    fun register(@RequestBody store: Store): Int? {
        repository.save(store)
        return store.id
    }
    /* @PostMapping("/register")  //---  수정본 -> 정상 작동 확인 후 교체
        fun register(@RequestBody store: Store): Int? {
        val savedStore = repository.save(store)
        return savedStore.id
        }*/


    @RequestMapping("/id")
    fun getOneStore(id: Int): Store? = repository.findStoreById(id)

    /*@GetMapping("/{id}") /---  수정본 -> 정상 작동 확인 후 교체
      fun getOneStore(@PathVariable id: Int): Store? = repository.findStoreById(id) */

    // 매장 정보 수정 API
    @PutMapping("update/{id}")
    fun updateStore(
        @PathVariable id: Int,
        @RequestBody storeUpdate: Store
    ): ResponseEntity<Any> {
        val optionalStore = repository.findById(id)
        if (optionalStore.isPresent) {
            val store = optionalStore.get()
            store.name = storeUpdate.name
            store.registration = storeUpdate.registration
            store.address = storeUpdate.address
            store.latitude = storeUpdate.latitude
            store.longitude = storeUpdate.longitude
            store.phone = storeUpdate.phone
            store.openTime = storeUpdate.openTime
            store.noticeId = storeUpdate.noticeId
            store.profilePic = storeUpdate.profilePic
            store.backgroundPic = storeUpdate.backgroundPic
            store.onPromotion = storeUpdate.onPromotion
            repository.save(store)
            return ResponseEntity.ok("Store with id $id has been updated.")
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Store with id $id not found.")
    }
}