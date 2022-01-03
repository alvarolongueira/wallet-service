package com.playtomic.tests.wallet.business.action;

import org.springframework.stereotype.Service;

import com.playtomic.tests.wallet.api.request.GiveBackWalletRequest;
import com.playtomic.tests.wallet.business.GiveBackTransferService;
import com.playtomic.tests.wallet.domain.Wallet;

@Service
public class GiveBackTransferServiceAction implements GiveBackTransferService {

    @Override
    public Wallet giveBack(GiveBackWalletRequest request) {
        //TODO
        return null;
    }
}
