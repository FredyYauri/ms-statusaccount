package com.proyecto.statusaccount.msstatusaccount.controller;

import com.proyecto.statusaccount.msstatusaccount.entity.StatusAccount;
import com.proyecto.statusaccount.msstatusaccount.model.Account;
import com.proyecto.statusaccount.msstatusaccount.model.Credit;
import com.proyecto.statusaccount.msstatusaccount.model.StatusAccountModel;
import com.proyecto.statusaccount.msstatusaccount.service.StatusAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.EntityResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/statusaccount")
@Slf4j
public class StatusAccontController {
    @Autowired
    StatusAccountService statusAccountService;


    //    @GetMapping("/{idCustomer}")
//    public Flux<Account> getAccounts(@PathVariable Integer idCustomer){
//        log.info("(1): " + idCustomer);
//        return statusAccountService.getAccount(idCustomer);
//    }

//    @GetMapping("/dos/{idCustomer}")
//    public Mono<ResponseEntity<List<Credit>>> getAccountsF(@PathVariable Integer idCustomer) {
//        log.info("(1)" + idCustomer);
//        return statusAccountService.getAccount1(idCustomer)
//                .map(respuesta -> ResponseEntity.ok()
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .body(respuesta))
//                .defaultIfEmpty(ResponseEntity.notFound().build());
//    }


    @GetMapping("/dos/{idCustomer}")
    public Flux<Credit> getAccountsF(@PathVariable Integer idCustomer) {
        log.info("(1)" + idCustomer);
        return statusAccountService.getAccount1(idCustomer);
    }

    @GetMapping("/{idStatusAccount}")
    public Mono<StatusAccountModel> getStatusAccountByID(@PathVariable Integer idStatusAccount) {
        return statusAccountService.getStatusAccountByID(idStatusAccount);
    }

    @PostMapping()
    public Mono<StatusAccount> saveStatusAccountByID(@RequestBody StatusAccount statusAccount) {
        return statusAccountService.saveStatusAccountByID(statusAccount);
    }
}
