package com.proyecto.statusaccount.msstatusaccount.service;

import com.proyecto.statusaccount.msstatusaccount.entity.StatusAccount;
import com.proyecto.statusaccount.msstatusaccount.model.Account;
import com.proyecto.statusaccount.msstatusaccount.model.Credit;
import com.proyecto.statusaccount.msstatusaccount.model.Customer;
import com.proyecto.statusaccount.msstatusaccount.model.StatusAccountModel;
import com.proyecto.statusaccount.msstatusaccount.repository.StatusAccountRepository;
import com.proyecto.statusaccount.msstatusaccount.serviceclient.AccountREST;
import com.proyecto.statusaccount.msstatusaccount.serviceclient.CreditREST;
import com.proyecto.statusaccount.msstatusaccount.serviceclient.CustomerREST;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatusAccountServiceImpl implements StatusAccountService {

    @Autowired
    StatusAccountRepository statusAccountRepository;
    @Autowired
    AccountREST accountREST;
    @Autowired
    CustomerREST customerREST;
    @Autowired
    CreditREST creditREST;

    @Override
    public Flux<Credit> getAccount1(Integer idCustomer) {
        return null;

    }

    ModelMapper modelMapper;

    @Override
    public Mono<StatusAccountModel> getStatusAccountByID(Integer idStatusAccount) {
        log.info("0");


        Mono<StatusAccountModel> statusModel2 = getStatusAccount(idStatusAccount).flatMap(statusAccount ->
                Mono.zip(getCustomer(statusAccount.getIdCustomer()), getAccountCustomer(statusAccount.getIdCustomer()), getCreditCustomer(statusAccount.getIdCustomer()))
                        .map(T ->
                                new StatusAccountModel(T.getT1(), T.getT2(), T.getT3())
                        )
        );



        return statusModel2;
    }

    @Override
    public Mono<StatusAccount> getStatusAccount(Integer idStatusAccount) {
        log.info("getStatusAccount");
        return statusAccountRepository.findById(idStatusAccount).doOnNext(x -> log.info(x.getIdStatusAccount().toString()));
    }

    private Mono<Customer> getCustomer(Integer idCustomer) {
        log.info("getCustomer");
        Mono<Customer> customerMono = customerREST.getCustomerBy(idCustomer);
        return customerMono;
    }

    private Mono<List<Account>> getAccountCustomer(Integer idCustomer) {
        log.info("getAccountCustomer");
        Mono<List<Account>> lstAccount = accountREST.getAccountByCustomer(idCustomer);
        return lstAccount;
    }

    private Mono<List<Credit>> getCreditCustomer(Integer idCustomer) {
        log.info("getCreditCustomer");
        Mono<List<Credit>> lstAccount = creditREST.getCreditByCustomer(idCustomer);
        return lstAccount;
    }

    public Mono<StatusAccount> saveStatusAccountByID(StatusAccount statusAccount) {
        return statusAccountRepository.save(statusAccount);
    }
}


