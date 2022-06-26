package com.proyecto.statusaccount.msstatusaccount.controller;

import com.proyecto.statusaccount.msstatusaccount.entity.StatusAccount;
import com.proyecto.statusaccount.msstatusaccount.service.StatusAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping(value = "/statusaccount")
public class StatusAccountController {
    @Autowired
    private StatusAccountService statusAccountService;

    @GetMapping
    public Flux<StatusAccount> getAll(){
        return statusAccountService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<StatusAccount> getAccountByID(@PathVariable Integer id){
        return statusAccountService.getAccountByID(id);
    }

    @PostMapping
    public Mono<StatusAccount> saveAccount(@RequestBody StatusAccount account){
        return statusAccountService.saveAccount(account);
    }

    @PutMapping
    public Mono<StatusAccount> updateAccount(@RequestBody StatusAccount account){
        return statusAccountService.updateAccount(account);
    }

    @DeleteMapping("/{id}")
    public Mono<StatusAccount> deleteAccount(@PathVariable Integer id){
        return statusAccountService.deleteAccount(id);
    }

    @GetMapping("/bycustomer/{idConsumer}")
    public Flux<StatusAccount> getAccountByIdCustomer(@PathVariable Integer idConsumer){
        return statusAccountService.getAccountByIdCustomer(idConsumer);
    }

}
