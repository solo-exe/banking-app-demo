package com.sollo_scripts.banking_app.service;

import com.sollo_scripts.banking_app.dto.AccountDto;
import com.sollo_scripts.banking_app.entity.Account;

public interface AccountService {

    AccountDto createAccount (AccountDto accountDto);
}
