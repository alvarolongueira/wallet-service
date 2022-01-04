package com.playtomic.tests.wallet.business.action;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.playtomic.tests.wallet.api.request.LoadWalletRequest;
import com.playtomic.tests.wallet.business.LoadWalletService;
import com.playtomic.tests.wallet.domain.ThirdParty;
import com.playtomic.tests.wallet.domain.Wallet;
import com.playtomic.tests.wallet.exception.domain.NegativeAmountException;
import com.playtomic.tests.wallet.provider.CurrencyProvider;
import com.playtomic.tests.wallet.provider.ThirdPartyProvider;
import com.playtomic.tests.wallet.respository.TransferEntityManager;
import com.playtomic.tests.wallet.respository.WalletEntityManager;

@Service
public class LoadWalletServiceAction implements LoadWalletService {

    private final WalletEntityManager walletManager;
    private final TransferEntityManager transferManager;
    private final CurrencyProvider currencyProvider;
    private final ThirdPartyProvider thirdPartyProvider;

    LoadWalletServiceAction(WalletEntityManager walletManager,
            TransferEntityManager transferManager,
            CurrencyProvider currencyProvider,
            ThirdPartyProvider thirdPartyProvider) {
        this.walletManager = walletManager;
        this.transferManager = transferManager;
        this.currencyProvider = currencyProvider;
        this.thirdPartyProvider = thirdPartyProvider;
    }

    @Override
    public Wallet load(LoadWalletRequest request) {

        long walletId = request.getWalletId();
        Wallet oldWallet = this.walletManager.find(walletId);
        BigDecimal requestAmount = request.getAmount();

        if (BigDecimal.ZERO.compareTo(requestAmount) > 0) {
            throw new NegativeAmountException(requestAmount);
        }

        BigDecimal convertedAmount = this.convert(requestAmount);

        this.chargeToThirdParty(convertedAmount);

        this.transferManager.insert(walletId, convertedAmount);

        BigDecimal newAmount = oldWallet.getAmount().add(convertedAmount);
        Wallet newWallet = oldWallet.withAmount(newAmount);
        this.walletManager.update(newWallet);

        return newWallet;
    }

    private void chargeToThirdParty(BigDecimal amount) {
        //TODO there is to define how to recover sensitive info
        this.thirdPartyProvider.charge(ThirdParty.STRIPE, "1111 2222 3333 4444", amount);
    }

    private BigDecimal convert(BigDecimal amount) {
        //TODO there is to define how to recover old currency and decide new one
        Locale systemLocale = LocaleContextHolder.getLocale();
        Currency sourceCurrency = Currency.getInstance(systemLocale);
        Currency targetCurrency = Currency.getInstance(Locale.getDefault());
        return this.currencyProvider.change(amount, sourceCurrency, targetCurrency);
    }
}
