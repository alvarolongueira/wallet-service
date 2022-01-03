package com.playtomic.tests.wallet.business;

import com.playtomic.tests.wallet.domain.Wallet;

public interface FindWalletService {

    Wallet find(long walletId);

}
