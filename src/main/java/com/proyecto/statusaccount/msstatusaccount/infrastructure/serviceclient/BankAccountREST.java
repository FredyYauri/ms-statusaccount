package com.proyecto.statusaccount.msstatusaccount.infrastructure.serviceclient;
import com.proyecto.statusaccount.msstatusaccount.application.config.RestConfig;
import com.proyecto.statusaccount.msstatusaccount.domain.dto.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class BankAccountREST {
    RestConfig restConfig = new RestConfig();
    public Flux<Account> getAccountByCustomer(Integer idCustomer) {
        log.info("Invoca al micro ms-account: " + idCustomer);
        return restConfig.getWebClient("http://localhost:8083")
                .build()
                .get()
                .uri("/bankaccount/bycustomer/" + idCustomer)
                .retrieve()
                .bodyToFlux(Account.class);
    }

}
