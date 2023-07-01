package ru.test.first

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestAttribute
import org.springframework.web.bind.annotation.RestController

@RestController("api/v1")
class FirstRestController {
    val log = LoggerFactory.getLogger(FirstRestController::class.java)

    @GetMapping("echo/\${s}")
    fun echo(@RequestAttribute s: String): String {
        log.info("Got message < $s > on the First service")
        return s
    }
}