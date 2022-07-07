package com.proyecto.statusaccount.msstatusaccount.domain.service;

import com.proyecto.statusaccount.msstatusaccount.domain.dto.StatusAccountDto;
import com.proyecto.statusaccount.msstatusaccount.infrastructure.entity.StatusAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StatusAccountService {
    Mono<StatusAccountDto> getAllProducts (Integer idCustomer);

}
