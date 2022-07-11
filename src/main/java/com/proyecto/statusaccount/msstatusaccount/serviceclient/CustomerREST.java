package com.proyecto.statusaccount.msstatusaccount.serviceclient;

import com.proyecto.statusaccount.msstatusaccount.model.Credit;
import com.proyecto.statusaccount.msstatusaccount.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class CustomerREST {
    WebClient.Builder getWebClient(String url) {
        return WebClient.builder().baseUrl(url);
    }

    public Mono<Customer> getCustomerBy(Integer idCustomer) {
        log.info("Invoca al micro ms-customer");
        return getWebClient("http://localhost:8082")
                .build()
                .get()
                .uri("/customer/" + idCustomer)
                .retrieve()
                .bodyToMono(Customer.class);
    }
}
