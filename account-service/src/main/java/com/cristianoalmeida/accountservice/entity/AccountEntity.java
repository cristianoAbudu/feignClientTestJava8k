package com.cristianoalmeida.accountservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class AccountEntity{
    private Long id;
    private Long customerId;
    private BigDecimal balance;
}
