package com.proyecto.statusaccount.msstatusaccount.model;

import lombok.*;
import reactor.core.publisher.Mono;

import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StatusAccountModel {
    private Customer consumer;
    private List<Account> accounts;
    private List<Credit> credits;
}
