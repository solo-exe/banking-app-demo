package com.sollo_scripts.banking_app.dto;

public record AccountDto(
                Long id,
                String accountName,
                double balance) {
}