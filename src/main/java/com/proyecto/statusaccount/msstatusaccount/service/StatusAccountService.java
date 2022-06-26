package com.proyecto.statusaccount.msstatusaccount.service;

import com.proyecto.statusaccount.msstatusaccount.entity.StatusAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StatusAccountService {
    Flux<StatusAccount> getAll();
    Mono<StatusAccount> getAccountByID(Integer idAccount);
    Mono<StatusAccount> saveAccount(StatusAccount account);
    Mono<StatusAccount> updateAccount(StatusAccount account);
    Mono<StatusAccount> deleteAccount(Integer idAccount);
    Flux<StatusAccount> getAccountByIdCustomer(Integer idCustomer);

}
