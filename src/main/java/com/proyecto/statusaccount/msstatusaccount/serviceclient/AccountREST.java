package com.proyecto.statusaccount.msstatusaccount.serviceclient;

import com.proyecto.statusaccount.msstatusaccount.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class AccountREST {

    WebClient.Builder getWebClient(String url) {
        return WebClient.builder().baseUrl(url);
    }

    public Mono<List<Account>> getAccountByCustomer(Integer idCustomer) {
        log.info("Invoca al micro ms-account");
        ParameterizedTypeReference<List<Account>> rolesType = new ParameterizedTypeReference<List<Account>>() {};
        return getWebClient("http://localhost:8083")
                .build()
                .get()
                .uri("/bankaccount/bycustomer/" + idCustomer)
                .retrieve()
                .bodyToMono(rolesType);
    }
//    public Flux<Account> getAccountByCustomer(Integer idCustomer) {
//        log.info("Invoca al micro ms-account");
//        return getWebClient("http://localhost:8083")
//                .build()
//                .get()
//                .uri("/accounts/bycustomer/" + idCustomer)
//                .retrieve()
//                .bodyToFlux(Account.class);
//    }

}