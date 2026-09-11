package com.cristianoalmeida.accountservice.util;

import com.cristianoalmeida.accountservice.dto.CustomerDTO;
import com.cristianoalmeida.accountservice.entity.AccountEntity;
import com.cristianoalmeida.accountservice.dto.AccountDTO;
public class AccountConverter {

    public static AccountDTO convert(
            AccountEntity accountEntity,
            CustomerDTO customerDTO)
    {

        return new AccountDTO(
            accountEntity.getId(),
            accountEntity.getBalance(),
            customerDTO
        );
    }
}
