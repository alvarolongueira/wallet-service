package com.playtomic.tests.wallet.exception.domain;

import java.util.Currency;

import org.springframework.http.HttpStatus;

import com.playtomic.tests.wallet.exception.WalletServiceException;

public class CurrencyNotFoundException extends WalletServiceException {

    private static final long serialVersionUID = 8511245611071664234L;

    public CurrencyNotFoundException(Currency currency) {
        super("Currency not found" + currency.getCurrencyCode(), HttpStatus.NOT_FOUND);
    }

}
