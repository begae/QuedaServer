package com.whoasys.quedaserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class QuedaServerApplication

fun main(args: Array<String>) {
    runApplication<QuedaServerApplication>(*args)
}
