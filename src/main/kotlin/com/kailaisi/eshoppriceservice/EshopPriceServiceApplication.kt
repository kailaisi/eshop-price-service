package com.kailaisi.eshoppriceservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class EshopPriceServiceApplication

fun main(args: Array<String>) {
    runApplication<EshopPriceServiceApplication>(*args)
}
