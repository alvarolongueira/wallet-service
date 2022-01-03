package com.playtomic.tests.wallet.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WalletServiceExceptionHandler {

    @ExceptionHandler(WalletServiceException.class)
    public ResponseEntity<String> handleClientException(WalletServiceException e) {
        return new ResponseEntity<String>(e.getMessage(), e.getStatus());
    }

}
