package br.com.alisonviana.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@ConfigurationProperties("spring.datasource")
class DBConfiguration {

    var driverClassName = ""
    var url = ""

    @Profile("test")
    @Bean
    fun testDatabaseConnection(): String {
        println(driverClassName)
        println(url)

        return "Test environment database connection"
    }

    @Profile("dev")
    @Bean
    fun devDatabaseConnection(): String {
        println(driverClassName)
        println(url)

        return "Dev environment database connection"
    }

}