package com.sollo_scripts.banking_app.service.impl;

import com.sollo_scripts.banking_app.dto.AccountDto;
import com.sollo_scripts.banking_app.entity.Account;
import com.sollo_scripts.banking_app.exception.AccountException;
import com.sollo_scripts.banking_app.mapper.AccountMapper;
import com.sollo_scripts.banking_app.repository.AccountRepository;
import com.sollo_scripts.banking_app.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private AccountDto updateAccount (Account account, double total) {
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = this.accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto depositFunds(Long id, Double amount) {
        Account account = this.accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountException("Account does not exist"));

        double total = account.getBalance() + amount;
        return this.updateAccount(account, total);
    }

    @Override
    public AccountDto withdrawFunds(Long id, Double amount) {
        Account account = this.accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountException("Account does not exist"));

        if (account.getBalance() < amount) {
            throw new AccountException("Insufficient Balance");
        }

        double total =   account.getBalance() - amount;
        return this.updateAccount(account, total);
    }

    @Override
    public List<AccountDto> listAccounts() {
        List<Account> accounts = this.accountRepository.findAll();
//        accounts.stream().map(account -> AccountMapper.mapToAccountDto(account))
//                .collect(Collectors.toList());
        return accounts.stream().map(AccountMapper::mapToAccountDto).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = this.accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountException("Account does not exist"));
        accountRepository.deleteById(id);
    }
}
