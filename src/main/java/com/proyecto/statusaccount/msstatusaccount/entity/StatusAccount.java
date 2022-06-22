package com.proyecto.statusaccount.msstatusaccount.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "statusAccounts")
public class StatusAccount {
    @Id
    private Integer idStatusAccount;
    private String idCustomer;
    private String nameCustomer;
    private List<Account> accounts;
}
