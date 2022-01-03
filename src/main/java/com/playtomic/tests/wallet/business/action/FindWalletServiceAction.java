package com.playtomic.tests.wallet.business.action;

import org.springframework.stereotype.Service;

import com.playtomic.tests.wallet.business.FindWalletService;
import com.playtomic.tests.wallet.domain.Wallet;
import com.playtomic.tests.wallet.exception.domain.WalletNotFoundException;
import com.playtomic.tests.wallet.respository.WalletEntityManager;

@Service
public class FindWalletServiceAction implements FindWalletService {

    private final WalletEntityManager manager;

    public FindWalletServiceAction(WalletEntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Wallet find(long walletId) throws WalletNotFoundException {
        return this.manager.find(walletId);
    }
}
