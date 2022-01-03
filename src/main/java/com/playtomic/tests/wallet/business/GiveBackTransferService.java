package com.playtomic.tests.wallet.business;

import com.playtomic.tests.wallet.api.request.GiveBackWalletRequest;
import com.playtomic.tests.wallet.domain.Wallet;

public interface GiveBackTransferService {

    Wallet giveBack(GiveBackWalletRequest request);

}
