package com.proyecto.statusaccount.msstatusaccount.domain.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Integer idAccount;
    private String numberAccount;
    private Float balance;
    private Integer idCustomer;
    private String accountType;
}