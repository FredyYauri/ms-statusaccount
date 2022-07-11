package com.proyecto.statusaccount.msstatusaccount.entity;

import com.proyecto.statusaccount.msstatusaccount.model.Account;
import com.proyecto.statusaccount.msstatusaccount.model.Credit;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Flux;

@Getter
@Setter
@Document(collection = "statusAccounts")
public class StatusAccount {
    @Id
    private Integer idStatusAccount;
    private Integer idCustomer;
    private String nameCustomer;
}
