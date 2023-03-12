package com.whoasys.quedaserver.user

import com.whoasys.quedaserver.store.StoreRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(private val repository: UserRepository,
                     private val storeRepository: StoreRepository
) {

    @PostMapping("/join")
    fun join(@RequestBody user: User): User? {

        val sameIdOwner = repository.findUserById(user.id)
        return if (sameIdOwner == null) {
            repository.save(user)
            user
        } else null
    }

    @GetMapping("/id")
    fun findUserById(id: String): User? = repository.findUserById(id)

    @GetMapping("/with")
    fun findUserByStoreId(storeId: Int): User? = repository.findUserByStoreId(storeId)

    @GetMapping("/login")
    fun login(id: String, pw: String): User? =
        repository.findUserByIdAndPw(id, pw)

    @PostMapping("/manager")
    fun updateUserAsManager(userId: String, storeId: Int): Boolean {

        val newStore = storeRepository.findStoreById(storeId)
        val oldUser = repository.findUserById(userId)
        return if (oldUser == null) {
            false
        } else {
            repository.deleteById(userId)
            val newUser = User(oldUser.id, oldUser.pw, oldUser.name, oldUser.email,
                null, null, true, newStore)
            repository.save(newUser)
            true
        }
    }
}