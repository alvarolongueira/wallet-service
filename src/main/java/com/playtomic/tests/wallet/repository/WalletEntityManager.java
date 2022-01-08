package com.playtomic.tests.wallet.repository;

import com.playtomic.tests.wallet.domain.Wallet;
import com.playtomic.tests.wallet.exception.domain.WalletNotFoundException;

public interface WalletEntityManager {

    public Wallet find(long walletId) throws WalletNotFoundException;

    public Wallet create();

    public void update(Wallet wallet);

}
