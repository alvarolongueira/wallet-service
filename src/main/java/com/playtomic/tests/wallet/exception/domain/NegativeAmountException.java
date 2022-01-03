package com.playtomic.tests.wallet.exception.domain;

import org.springframework.http.HttpStatus;

import com.playtomic.tests.wallet.exception.WalletServiceException;

public class NegativeAmountException extends WalletServiceException {

    private static final long serialVersionUID = 8511245611071664234L;

    public NegativeAmountException() {
        super("Amount negative not allowed", HttpStatus.NOT_FOUND);
    }

    public NegativeAmountException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
