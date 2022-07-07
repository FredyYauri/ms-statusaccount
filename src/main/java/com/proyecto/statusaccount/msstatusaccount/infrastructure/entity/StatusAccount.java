package com.proyecto.statusaccount.msstatusaccount.infrastructure.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "accounts")
public class StatusAccount {
    @Id
    private Integer idStatusAccount;
    private Integer idCustomer;
    private String nameCustomer;
}
