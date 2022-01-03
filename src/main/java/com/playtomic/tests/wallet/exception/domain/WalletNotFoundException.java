package com.playtomic.tests.wallet.exception.domain;

import org.springframework.http.HttpStatus;

import com.playtomic.tests.wallet.exception.WalletServiceException;

public class WalletNotFoundException extends WalletServiceException {

    private static final long serialVersionUID = -2750635806121137522L;

    public WalletNotFoundException(long userId) {
        super("Wallet with id " + userId + " not found", HttpStatus.NOT_FOUND);
    }

    public WalletNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
