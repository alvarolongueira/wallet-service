package com.playtomic.tests.wallet.exception.domain;

import org.springframework.http.HttpStatus;

import com.playtomic.tests.wallet.exception.WalletServiceException;

public class ThirdPartyNotAvailable extends WalletServiceException {

    private static final long serialVersionUID = 8511245611071664234L;

    public ThirdPartyNotAvailable() {
        super("Third party service not available", HttpStatus.NOT_FOUND);
    }

}
