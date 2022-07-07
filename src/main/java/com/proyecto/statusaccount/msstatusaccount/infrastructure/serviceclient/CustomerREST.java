package com.proyecto.statusaccount.msstatusaccount.infrastructure.serviceclient;

import com.proyecto.statusaccount.msstatusaccount.application.config.RestConfig;
import com.proyecto.statusaccount.msstatusaccount.domain.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class CustomerREST {
    RestConfig restConfig = new RestConfig();

    public Mono<Customer> getCustomerBy(Integer idCustomer) {
        log.info("Invoca al micro ms-customer");
        return restConfig.getWebClient("http://localhost:8082")
                .build()
                .get()
                .uri("/customer/" + idCustomer)
                .retrieve()
                .bodyToMono(Customer.class);
    }
}
