package com.playtomic.tests.wallet.business.action;

import org.springframework.stereotype.Service;

import com.playtomic.tests.wallet.business.FindAllTransferService;
import com.playtomic.tests.wallet.domain.Wallet;

@Service
public class FindAllTransferServiceAction implements FindAllTransferService {

    @Override
    public Wallet find(long walletId) {
        //TODO
        return null;
    }

}
