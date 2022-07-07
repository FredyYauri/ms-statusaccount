package com.proyecto.statusaccount.msstatusaccount.domain.service;

import com.proyecto.statusaccount.msstatusaccount.domain.dto.Account;
import com.proyecto.statusaccount.msstatusaccount.domain.dto.Credit;
import com.proyecto.statusaccount.msstatusaccount.domain.dto.Customer;
import com.proyecto.statusaccount.msstatusaccount.domain.dto.StatusAccountDto;
import com.proyecto.statusaccount.msstatusaccount.infrastructure.entity.StatusAccount;
import com.proyecto.statusaccount.msstatusaccount.infrastructure.serviceclient.BankAccountREST;
import com.proyecto.statusaccount.msstatusaccount.infrastructure.serviceclient.CreditREST;
import com.proyecto.statusaccount.msstatusaccount.infrastructure.serviceclient.CustomerREST;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

@Service
@Slf4j
public class StatusAccountServiceImpl implements StatusAccountService {
    @Autowired
    CustomerREST customerREST;
    @Autowired
    BankAccountREST bankAccountREST;
    @Autowired
    CreditREST creditREST;

    @Override
    public Mono<StatusAccountDto> getAllProducts(Integer idCustomer) {
        StatusAccountDto statusAccountDto = new StatusAccountDto();
        log.info("1");
        statusAccountDto.setConsumer(customerREST.getCustomerBy(idCustomer));
        log.info("2");
        statusAccountDto.setCredits(creditREST.getCreditByCustomer(idCustomer));
        log.info("3");
        statusAccountDto.setAccounts(bankAccountREST.getAccountByCustomer(idCustomer));
        log.info("4");

//        Mono<StatusAccountDto> statusAccountDtoMono = Mono.just(new StatusAccountDto(getCustomerById(idCustomer), bankAccountREST.getAccountByCustomer(idCustomer), creditREST.getCreditByCustomer(idCustomer)));
//        statusAccountDtoMono.subscribe();
//        return statusAccountDtoMono;
        return Mono.just(statusAccountDto);
    }

    private Mono<Customer> getCustomerById(Integer idCustomer) {
        Mono<Customer> customerMono = customerREST.getCustomerBy(idCustomer);
        customerMono.subscribe();
        return customerMono;
    }
}
