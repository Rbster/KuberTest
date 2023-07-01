package ru.test.second

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("api/v1")
class SecondRestController {
    val log = LoggerFactory.getLogger(SecondRestController::class.java)

    @GetMapping("echo")
    fun echo(s: String): String {
        log.info("Got message < $s > on the Second service")
        return s
    }
}