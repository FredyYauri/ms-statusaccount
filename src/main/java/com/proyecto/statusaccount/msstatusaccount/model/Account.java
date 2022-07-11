package com.proyecto.statusaccount.msstatusaccount.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Integer idAccount;      //id de cuenta
    private String numberAccount;   //número de cuenta
    private Float balance;          //saldo
    private Integer idCustomer;     //id de cliente
    private String accountType;     //tipo de cuenta
}