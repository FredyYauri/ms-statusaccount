package com.proyecto.statusaccount.msstatusaccount.domain.dto;

import lombok.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StatusAccountDto {
    private Mono<Customer> consumer;
    private Flux<Account> accounts;
    private Flux<Credit> credits;
}
