package com.proyecto.statusaccount.msstatusaccount.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Integer idCustomer;
    private String name;
    private String documentType;
    private String documentNumber;
    private String customerType;
}
