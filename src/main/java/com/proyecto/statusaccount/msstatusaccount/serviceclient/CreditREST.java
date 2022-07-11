package com.proyecto.statusaccount.msstatusaccount.serviceclient;

import com.proyecto.statusaccount.msstatusaccount.model.Account;
import com.proyecto.statusaccount.msstatusaccount.model.Credit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class CreditREST {
    WebClient.Builder getWebClient(String url) {
        return WebClient.builder().baseUrl(url);
    }

    public Mono<List<Credit>> getCreditByCustomer(Integer idCustomer) {
        log.info("Invoca al micro ms-credit");
        ParameterizedTypeReference<List<Credit>> lstCredit = new ParameterizedTypeReference<List<Credit>>() {
        };
        return getWebClient("http://localhost:8098")
                .build()
                .get()
                .uri("/credit/bycustomer/" + idCustomer)
                .retrieve()
                .bodyToMono(lstCredit);
    }

    public Flux<Credit> getCreditByCustomer1(Integer idCustomer) {
        log.info("Invoca al micro ms-credit");
        return getWebClient("http://localhost:8084")
                .build()
                .get()
                .uri("/credit/byCustomer/" + idCustomer)
                .retrieve()
                .bodyToFlux(Credit.class);
    }
}
