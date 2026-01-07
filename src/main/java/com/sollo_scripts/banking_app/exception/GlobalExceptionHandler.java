package com.sollo_scripts.banking_app.exception;

import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

        // Handle Specific Exceptions
        @ExceptionHandler(AccountException.class)
        public ResponseEntity<@NonNull ErrorDetails> handleAccountException(
                        AccountException exception,
                        WebRequest webRequest) {
                ErrorDetails errorDetails = new ErrorDetails(
                                LocalDateTime.now(),
                                exception.getMessage(),
                                webRequest.getDescription(false),
                                "ACCOUNT_NOT_FOUND");

                return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
        }

        // Handle Generic Exceptions
        @ExceptionHandler(Exception.class)
        public ResponseEntity<@NonNull ErrorDetails> handleGenericException(Exception exception,
                        WebRequest webRequest) {
                ErrorDetails errorDetails = new ErrorDetails(
                                LocalDateTime.now(),
                                exception.getMessage(),
                                webRequest.getDescription(false),
                                "INTERNAL_SERVER_ERROR");
                return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
