package com.proyecto.statusaccount.msstatusaccount.repository;


import com.proyecto.statusaccount.msstatusaccount.entity.StatusAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface StatusAccountRepository extends ReactiveMongoRepository <StatusAccount, Integer> {
}
