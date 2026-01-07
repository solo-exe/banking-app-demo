package com.sollo_scripts.banking_app.controller;

import com.sollo_scripts.banking_app.dto.AccountDto;
import com.sollo_scripts.banking_app.service.AccountService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<@NonNull List<AccountDto>> listAccounts () {
        return new ResponseEntity<@NonNull List<AccountDto>>(accountService.listAccounts(), HttpStatus.OK);
    }

    // Add account rest api
    @PostMapping("/add")
    public ResponseEntity<@NonNull AccountDto> addAccount (@Valid @RequestBody AccountDto accountDto) {
        return new ResponseEntity<@NonNull AccountDto>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/deposit")
    public  ResponseEntity<@NonNull AccountDto> depositFunds (
            @PathVariable Long id,
            @RequestBody Map<String, Double> request
    ) {
        Double amount = request.get("amount");
        return new ResponseEntity<@NonNull AccountDto>(accountService
                .depositFunds(id, amount), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}/withdraw")
    public  ResponseEntity<@NonNull AccountDto> withdrawFunds (
            @PathVariable Long id,
            @RequestBody Map<String, Double> request
    ) {
        Double amount = request.get("amount");
        return new ResponseEntity<@NonNull AccountDto>(accountService
                .withdrawFunds(id, amount), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<@NonNull AccountDto> getAccount (@PathVariable Long id ) {
        return new ResponseEntity<@NonNull AccountDto>(accountService.getAccountById((id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<@NonNull String> deleteAccount (@PathVariable  Long id) {
        accountService.deleteAccount(id);
        return  ResponseEntity.ok("Account deleted successfully");
    }
}
