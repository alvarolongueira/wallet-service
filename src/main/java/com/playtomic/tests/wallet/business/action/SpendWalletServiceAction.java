package com.playtomic.tests.wallet.business.action;

import org.springframework.stereotype.Service;

import com.playtomic.tests.wallet.api.request.SpendWalletRequest;
import com.playtomic.tests.wallet.business.SpendWalletService;
import com.playtomic.tests.wallet.domain.Wallet;

@Service
public class SpendWalletServiceAction implements SpendWalletService {

    @Override
    public Wallet spend(SpendWalletRequest request) {
        //TODO implementation not required for this test
        return null;
    }
}
