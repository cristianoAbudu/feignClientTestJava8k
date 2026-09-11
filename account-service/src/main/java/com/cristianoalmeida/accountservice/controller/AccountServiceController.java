package com.cristianoalmeida.accountservice.controller;

import com.cristianoalmeida.accountservice.dto.AccountDTO;
import com.cristianoalmeida.accountservice.dto.CustomerDTO;
import com.cristianoalmeida.accountservice.entity.AccountEntity;
import com.cristianoalmeida.accountservice.feign.CustomerFeignClient;
import com.cristianoalmeida.accountservice.util.AccountConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountServiceController {

    private Map<Long,AccountEntity> database = new HashMap<>();

    @Autowired
    private CustomerFeignClient customerFeignClient;

    public AccountServiceController(){
        database.put(
            1L,
            new AccountEntity(
                100L,
                1L,
                new BigDecimal("1500.50")
            )
        );
    }

    @GetMapping("/{id}")
    public AccountDTO get(
            @PathVariable("id") Long id
    ){
        AccountEntity accountEntity = database.get(id);
        return AccountConverter.convert(
                accountEntity,
                customerFeignClient.get(
                        accountEntity.getCustomerId()
                )
        );
    }
}
