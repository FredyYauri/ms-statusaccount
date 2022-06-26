package com.proyecto.statusaccount.msstatusaccount.service;

import com.proyecto.statusaccount.msstatusaccount.entity.StatusAccount;
import com.proyecto.statusaccount.msstatusaccount.repository.StatusAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class StatusAccountServiceImpl implements StatusAccountService {
    @Autowired
    private StatusAccountRepository statusAccountRepository;
    @Override
    public Flux<StatusAccount> getAll() {
        return statusAccountRepository.findAll();
    }

    @Override
    public Mono<StatusAccount> getAccountByID(Integer idAccount) {
        return statusAccountRepository.findById(idAccount);
    }

    @Override
    public Flux<StatusAccount> getAccountByIdCustomer(Integer idCustomer) {
        return statusAccountRepository.findAll()
                .filter(account -> account.getIdCustomer() == idCustomer);
    }

    @Override
    public Mono<StatusAccount> saveAccount(StatusAccount account) {
        return statusAccountRepository.save(account);
    }

    @Override
    public Mono<StatusAccount> updateAccount(StatusAccount account) {
        return statusAccountRepository.findById(account.getIdStatusAccount())
                .flatMap(newAccount -> {
                    newAccount.setIdStatusAccount(account.getIdStatusAccount());
                    newAccount.setIdCustomer(account.getIdCustomer());
                    newAccount.setNameCustomer(account.getNameCustomer());
                    return statusAccountRepository.save(newAccount);
                });
    }

    @Override
    public Mono<StatusAccount> deleteAccount(Integer idAccount) {
        return statusAccountRepository.findById(idAccount)
                .flatMap(account -> statusAccountRepository.delete(account).then(Mono.just(account)));
    }
}
