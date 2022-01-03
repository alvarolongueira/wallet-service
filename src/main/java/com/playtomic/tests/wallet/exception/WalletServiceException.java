package com.playtomic.tests.wallet.exception;

import org.springframework.http.HttpStatus;

public abstract class WalletServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final HttpStatus status;

    public WalletServiceException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    HttpStatus getStatus() {
        return this.status;
    }

}
