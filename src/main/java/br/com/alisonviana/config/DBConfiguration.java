package br.com.alisonviana.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {

    private String driverClassName;
    private String url;

    @Profile("test")
    @Bean
    public String defaultDatabaseConnection() {
        System.out.println(driverClassName);
        System.out.println(url);

        return "Test environment DB connection";
    }

    @Profile("dev")
    @Bean
    public String devDatabaseConnection() {
        System.out.println(driverClassName);
        System.out.println(url);

        return "Dev environment DB connection";
    }

}
