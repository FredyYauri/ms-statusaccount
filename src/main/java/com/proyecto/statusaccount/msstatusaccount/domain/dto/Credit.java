package com.proyecto.statusaccount.msstatusaccount.domain.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Credit {
    private Integer idCredit;
    private Integer idConsumer;
    private String typeCredit;
    private Float creditLine;
    private String dateDue;
}
