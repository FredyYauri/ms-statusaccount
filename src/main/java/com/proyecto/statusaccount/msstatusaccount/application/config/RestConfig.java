package com.proyecto.statusaccount.msstatusaccount.application.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.WebClient;

@Configurable
public class RestConfig implements WebFluxConfigurer {
    @Bean
    public WebClient.Builder getWebClient(String url) {
        return WebClient.builder().baseUrl(url);
    }

}
