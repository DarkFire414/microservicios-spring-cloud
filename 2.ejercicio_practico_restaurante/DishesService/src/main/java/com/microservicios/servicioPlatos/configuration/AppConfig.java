package com.microservicios.servicioPlatos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean("apiConsumption")
    public RestTemplate registerRestTemplate() {
        return new RestTemplate();
    }
}
