package com.proyecto.statusaccount.msstatusaccount.infrastructure.serviceclient;

import com.proyecto.statusaccount.msstatusaccount.application.config.RestConfig;
import com.proyecto.statusaccount.msstatusaccount.domain.dto.Credit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Slf4j
@Service
public class CreditREST {
    RestConfig restConfig = new RestConfig();

    public Flux<Credit> getCreditByCustomer(Integer idCustomer) {
        log.info("Invoca al micro ms-credit");
        return restConfig.getWebClient("http://localhost:8084")
                .build()
                .get()
                .uri("/credit/bycustomer/" + idCustomer)
                .retrieve()
                .bodyToFlux(Credit.class);
    }
}
