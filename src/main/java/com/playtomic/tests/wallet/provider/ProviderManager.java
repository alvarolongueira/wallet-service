package com.playtomic.tests.wallet.provider;

import com.playtomic.tests.wallet.repository.TransferEntityManager;
import com.playtomic.tests.wallet.repository.WalletEntityManager;

public interface ProviderManager {

    CurrencyProvider getCurrencyProvider();

    ThirdPartyProvider getThirdPartyProvider();

    TransferEntityManager getTransferEntityManager();

    WalletEntityManager getWalletEntityManager();

}
