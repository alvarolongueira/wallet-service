package com.playtomic.tests.wallet.business.action;

import org.springframework.stereotype.Service;

import com.playtomic.tests.wallet.api.request.LoadWalletRequest;
import com.playtomic.tests.wallet.business.LoadWalletService;
import com.playtomic.tests.wallet.domain.Wallet;
import com.playtomic.tests.wallet.respository.TransferEntityManager;
import com.playtomic.tests.wallet.respository.WalletEntityManager;

@Service
public class LoadWalletServiceAction implements LoadWalletService {

    private WalletEntityManager walletManager;

    private TransferEntityManager transferManager;

    public LoadWalletServiceAction() {

    }

    LoadWalletServiceAction(WalletEntityManager walletManager, TransferEntityManager transferManager) {
        this.walletManager = walletManager;
        this.transferManager = transferManager;
    }

    @Override
    public Wallet load(LoadWalletRequest request) {

        long walletId = request.getWalletId();
        Wallet oldWallet = this.walletManager.find(walletId);
        long requestAmount = request.getAmount();

        long newAmount = oldWallet.getAmount() + requestAmount;
        Wallet newWallet = oldWallet.withAmount(newAmount);

        this.walletManager.update(newWallet);
        this.transferManager.insert(walletId, requestAmount);

        return this.walletManager.find(walletId);
    }
}
