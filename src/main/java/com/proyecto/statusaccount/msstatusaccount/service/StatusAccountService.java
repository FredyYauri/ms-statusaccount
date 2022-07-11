package com.proyecto.statusaccount.msstatusaccount.service;

import com.proyecto.statusaccount.msstatusaccount.entity.StatusAccount;
import com.proyecto.statusaccount.msstatusaccount.model.Account;
import com.proyecto.statusaccount.msstatusaccount.model.Credit;
import com.proyecto.statusaccount.msstatusaccount.model.StatusAccountModel;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface StatusAccountService {
    //    Flux<StatusAccount> getStatusAccountByID(Integer idStatusAccount);
//
//    Flux<Account> getAccount(Integer idCustomer);
    Flux<Credit> getAccount1(@PathVariable Integer idCustomer);
    Mono<StatusAccountModel>  getStatusAccountByID(Integer idStatusAccount);

    Mono<StatusAccount> saveStatusAccountByID(StatusAccount statstatusAccounModel);
    Mono<StatusAccount> getStatusAccount(Integer idStatusAccount);
}
