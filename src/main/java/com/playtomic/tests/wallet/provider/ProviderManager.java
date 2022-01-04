package com.playtomic.tests.wallet.provider;

import com.playtomic.tests.wallet.respository.TransferEntityManager;
import com.playtomic.tests.wallet.respository.WalletEntityManager;

public interface ProviderManager {

    CurrencyProvider getCurrencyProvider();

    ThirdPartyProvider getThirdPartyProvider();

    TransferEntityManager getTransferEntityManager();

    WalletEntityManager getWalletEntityManager();

}
