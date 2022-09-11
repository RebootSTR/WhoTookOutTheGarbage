package com.esg.garbage.ping

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.lang.IllegalArgumentException

@RestController
@RequestMapping("/ping")
class PingController @Autowired constructor() {

    @GetMapping(value = ["/disable"])
    fun pingEnable(): ResponseEntity<HttpStatus> {
        pingIsEnabled = false
        pingThread = null
        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping(value = ["/enable"])
    fun pingDisable(): ResponseEntity<HttpStatus> {
        pingIsEnabled = true
        pingThread = createThread()
        pingThread?.start()
        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping(value = ["/testError"])
    fun testError(): ResponseEntity<HttpStatus> {
        throw IllegalArgumentException("Why anton is here????")
        return ResponseEntity(HttpStatus.OK)
    }

    companion object {
        private const val pingUrl = "http://worldtimeapi.org/api/timezone/Europe/Moscow"
        private var pingThread: Thread? = null
        private val restTemplate
            get() = RestTemplate()
        private var pingIsEnabled = false
        private const val sleepTime = 25*60*1000L
        private val logger: Logger = LoggerFactory.getLogger(PingController::class.java)


        private fun createThread(): Thread {
            return Thread {
                while (true) {
                    if (pingIsEnabled) {
                        val result = restTemplate.getForEntity<String>(pingUrl)
                        logger.info("Ping: ${result.statusCode}")
                    } else {
                        return@Thread
                    }
                    Thread.sleep(sleepTime)
                }
            }.also {
                it.isDaemon = true
            }
        }
    }
}