package com.proyecto.statusaccount.msstatusaccount.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "accounts")
public class StatusAccount {
    @Id
    private Integer idStatusAccount;      //id de cuenta
    private Integer idCustomer;   //número de cuenta
    private String nameCustomer;          //saldo
}
