package com.sollo_scripts.banking_app.mapper;

import com.sollo_scripts.banking_app.dto.AccountDto;
import com.sollo_scripts.banking_app.entity.Account;

public class AccountMapper {
    public static Account mapToAccount (AccountDto accountDto) {
        return new Account (
                accountDto.getId(),
                accountDto.getAccountName(),
                accountDto.getBalance()
        );
    }

    public static AccountDto mapToAccountDto (Account account) {
        return new AccountDto(
                account.getId(),
                account.getAccountName(),
                account.getBalance()
        );
    }
}
