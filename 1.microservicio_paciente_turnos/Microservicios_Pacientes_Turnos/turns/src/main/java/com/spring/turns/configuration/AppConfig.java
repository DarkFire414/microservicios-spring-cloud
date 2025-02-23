package com.spring.turns.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    /**
     * Agrega un objeto RestTemplate al contenedor de Spring
     * @return objeto Rest Template
     */
    @Bean("apiConsumption")
    public RestTemplate registerRestTemplate(){
        return new RestTemplate();
    }
}
