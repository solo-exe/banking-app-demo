package com.sollo_scripts.banking_app.service;

import com.sollo_scripts.banking_app.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount (AccountDto accountDto);

    AccountDto getAccountById (Long id);

    AccountDto depositFunds (Long id, Double amount);

    AccountDto withdrawFunds (Long id, Double amount);

    List<AccountDto> listAccounts ();

    void deleteAccount (Long id);
}
