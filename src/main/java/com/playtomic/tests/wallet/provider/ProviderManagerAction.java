package com.playtomic.tests.wallet.provider;

import com.playtomic.tests.wallet.respository.TransferEntityManager;
import com.playtomic.tests.wallet.respository.WalletEntityManager;

public class ProviderManagerAction implements ProviderManager {

    private final WalletEntityManager walletManager;
    private final TransferEntityManager transferManager;
    private final CurrencyProvider currencyProvider;
    private final ThirdPartyProvider thirdPartyProvider;

    public ProviderManagerAction(WalletEntityManager walletManager,
            TransferEntityManager transferManager,
            CurrencyProvider currencyProvider,
            ThirdPartyProvider thirdPartyProvider) {
        this.walletManager = walletManager;
        this.transferManager = transferManager;
        this.currencyProvider = currencyProvider;
        this.thirdPartyProvider = thirdPartyProvider;
    }

    @Override
    public CurrencyProvider getCurrencyProvider() {
        return this.currencyProvider;
    }

    @Override
    public ThirdPartyProvider getThirdPartyProvider() {
        return this.thirdPartyProvider;
    }

    @Override
    public TransferEntityManager getTransferEntityManager() {
        return this.transferManager;
    }

    @Override
    public WalletEntityManager getWalletEntityManager() {
        return this.walletManager;
    }
}
