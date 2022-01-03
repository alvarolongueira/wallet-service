package com.playtomic.tests.wallet.business;

import com.playtomic.tests.wallet.api.request.LoadWalletRequest;
import com.playtomic.tests.wallet.domain.Wallet;

public interface LoadWalletService {

    Wallet load(LoadWalletRequest request);

}
