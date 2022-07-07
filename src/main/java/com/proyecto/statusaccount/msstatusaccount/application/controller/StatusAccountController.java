package com.proyecto.statusaccount.msstatusaccount.application.controller;

import com.proyecto.statusaccount.msstatusaccount.domain.dto.Account;
import com.proyecto.statusaccount.msstatusaccount.domain.dto.Credit;
import com.proyecto.statusaccount.msstatusaccount.domain.dto.Customer;
import com.proyecto.statusaccount.msstatusaccount.domain.dto.StatusAccountDto;
import com.proyecto.statusaccount.msstatusaccount.domain.service.StatusAccountService;
import com.proyecto.statusaccount.msstatusaccount.infrastructure.serviceclient.BankAccountREST;
import com.proyecto.statusaccount.msstatusaccount.infrastructure.serviceclient.CreditREST;
import com.proyecto.statusaccount.msstatusaccount.infrastructure.serviceclient.CustomerREST;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/statusaccount")
public class StatusAccountController {
    @Autowired
    StatusAccountService statusAccountService;

    /**
     * Método que devuelve todos los productos que tiene el cliente
     * @param idCustomer
     * @return
     */
    @GetMapping("/{idCustomer}")
    public Mono<StatusAccountDto> getStatusCustomer(@PathVariable Integer idCustomer){
        return statusAccountService.getAllProducts(idCustomer);
    }



//    BankAccountREST bankAccountREST = new BankAccountREST();
//
//    CreditREST creditREST = new CreditREST();
//
//    CustomerREST customerREST = new CustomerREST();

//    @GetMapping("/{idCustomer}")
//    public Mono<List<Account>> getAccountByCustomer(@PathVariable Integer idCustomer) {
//        log.info("Account idCustomer: " +idCustomer);
//        return bankAccountREST.getAccountByCustomer(idCustomer);
//    }
//
//    @GetMapping("/credit/{idCustomer}")
//    public Flux<Credit> getCredit(@PathVariable Integer idCustomer) {
//        log.info("Credit idCustomer: " +idCustomer);
//        return creditREST.getCreditByCustomer(idCustomer);
//    }
//
//    @GetMapping("/customer/{idCustomer}")
//    public Mono<Customer> getCustomer(@PathVariable Integer idCustomer) {
//        log.info("Customer idCustomer: " +idCustomer);
//        return customerREST.getCustomerBy(idCustomer);
//    }

}
