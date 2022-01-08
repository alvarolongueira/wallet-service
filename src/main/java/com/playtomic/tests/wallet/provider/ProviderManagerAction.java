package com.playtomic.tests.wallet.provider;

import org.springframework.stereotype.Component;

import com.playtomic.tests.wallet.repository.TransferEntityManager;
import com.playtomic.tests.wallet.repository.WalletEntityManager;

@Component
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
