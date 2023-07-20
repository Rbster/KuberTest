package ru.test.second

import org.springframework.http.MediaType.TEXT_PLAIN
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class AdapterFirst(val client: WebClient) {
    val targetUrl = "http://localhost:9998/api/v1/{msg}"

    fun send(msg: String) : String {
        return client.get()
            .uri(targetUrl, msg)
            .accept(TEXT_PLAIN).retrieve().bodyToMono(String::class.java).block().orEmpty()
    }
}