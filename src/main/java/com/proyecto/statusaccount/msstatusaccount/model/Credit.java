package com.proyecto.statusaccount.msstatusaccount.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Credit {
    private Integer idCredit;   //id credito
    private Integer idConsumer; //id cliente
    private String typeCredit;  //tipo crédito: personal,Empresarial o tarjeta de cred
    private Float creditLine;   //valor de crédito
    private String dateDue;     //fecha de vencimiento
}
