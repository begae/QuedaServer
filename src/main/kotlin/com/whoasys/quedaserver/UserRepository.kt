package com.whoasys.quedaserver

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@Transactional
interface UserRepository : CrudRepository<User, String> {

    fun findUserById(id: String): User?

    fun findUserByIdAndPw(id: String, pw: String): User?

    @Modifying
    @Query(value = "update user set is_manager=true, store_id=:storeId where id=:userId",
        nativeQuery = true)
    fun updateUserAsManager(userId: String, storeId: Int)
}

@RestController
@RequestMapping("/api/user")
class UserController(private val repository: UserRepository,
                     private val storeRepository: StoreRepository) {

    @PostMapping("/join")
    fun join(@RequestBody user: User): User? {

        val sameIdOwner = repository.findUserById(user.id)
        return if (sameIdOwner == null) {
            repository.save(user)
            user
        } else null
    }

    @GetMapping("/find")
    fun find(id: String): User? = repository.findUserById(id)

    @GetMapping("/login")
    fun login(id: String, pw: String): User? =
        repository.findUserByIdAndPw(id, pw)

    @PostMapping("/manager")
    fun updateUserAsManager(userId: String, storeId: Int): Boolean {

        val newStore = storeRepository.findStoreById(storeId)
        var oldUser = repository.findUserById(userId)
        return if (oldUser == null) {
            false
        } else {
            repository.deleteById(userId)
            val newUser = User(oldUser.id, oldUser.pw, oldUser.name, oldUser.email,
                true, newStore)
            repository.save(newUser)
            true
        }
    }
}