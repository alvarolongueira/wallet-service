package com.playtomic.tests.wallet.exception.domain;

import org.springframework.http.HttpStatus;

import com.playtomic.tests.wallet.exception.WalletServiceException;

public class CurrencyNotFoundException extends WalletServiceException {

    private static final long serialVersionUID = 8511245611071664234L;

    public CurrencyNotFoundException(String code) {
        super("Currency not found" + code, HttpStatus.NOT_FOUND);
    }

}
