package ru.test.second

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController("api/v1")
class SecondRestController(val adapterFirst: AdapterFirst) {
    val log = LoggerFactory.getLogger(SecondRestController::class.java)

    @GetMapping("get/{s}")
    fun proxy(@PathVariable s: String): String {
        log.info("Got message < $s > on the Second service")
        val rs = adapterFirst.send(s)
        log.info("Got message < $rs > from integration")
        return rs
    }

}