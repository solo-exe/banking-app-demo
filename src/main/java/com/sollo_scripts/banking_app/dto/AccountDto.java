package com.sollo_scripts.banking_app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
    private Long id;

    @NotBlank(message = "Account Name is required")
    private String accountName;

    @PositiveOrZero(message = "Balance cannot be negative")
    private double balance;
}