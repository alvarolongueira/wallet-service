package com.playtomic.tests.wallet.respository;

import com.playtomic.tests.wallet.domain.Wallet;

public interface WalletRepository {

    void create(Wallet wallet);

    Wallet findById(long walletId);

    void update(long walletId, long amount);

}
