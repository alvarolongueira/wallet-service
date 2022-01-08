package com.playtomic.tests.wallet.business.action;

import org.springframework.stereotype.Service;

import com.playtomic.tests.wallet.business.CreateWalletService;
import com.playtomic.tests.wallet.domain.Wallet;
import com.playtomic.tests.wallet.repository.WalletEntityManager;

@Service
public class CreateWalletServiceAction implements CreateWalletService {

    private final WalletEntityManager manager;

    public CreateWalletServiceAction(WalletEntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Wallet create() {
        return this.manager.create();
    }
}
