package com.playtomic.tests.wallet.business;

import com.playtomic.tests.wallet.api.request.SpendWalletRequest;
import com.playtomic.tests.wallet.domain.Wallet;

public interface SpendWalletService {

    Wallet spend(SpendWalletRequest request);

}
