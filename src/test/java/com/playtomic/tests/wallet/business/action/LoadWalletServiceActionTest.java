package com.playtomic.tests.wallet.business.action;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.playtomic.tests.wallet.api.request.LoadWalletRequest;
import com.playtomic.tests.wallet.business.LoadWalletService;
import com.playtomic.tests.wallet.domain.Wallet;
import com.playtomic.tests.wallet.exception.domain.CurrencyNotFoundException;
import com.playtomic.tests.wallet.exception.domain.NegativeAmountException;
import com.playtomic.tests.wallet.exception.domain.ThirdPartyNotAvailable;
import com.playtomic.tests.wallet.exception.domain.WalletNotFoundException;
import com.playtomic.tests.wallet.provider.CurrencyProvider;
import com.playtomic.tests.wallet.provider.ProviderManager;
import com.playtomic.tests.wallet.provider.ThirdPartyProvider;
import com.playtomic.tests.wallet.repository.TransferEntityManager;
import com.playtomic.tests.wallet.repository.WalletEntityManager;

@RunWith(MockitoJUnitRunner.class)
public class LoadWalletServiceActionTest {

    @Mock
    private ProviderManager providerManager;
    @Mock
    private WalletEntityManager walletManager;
    @Mock
    private TransferEntityManager transferManager;
    @Mock
    private CurrencyProvider currencyProvider;
    @Mock
    private ThirdPartyProvider thirdPartyProvider;

    private LoadWalletService service;
    private LoadWalletRequest request;

    private final Currency CURRENCY = Currency.getInstance(Locale.getDefault());

    @Before
    public void init() {
        this.service = new LoadWalletServiceAction(this.providerManager);
        this.request = new LoadWalletRequest(1, BigDecimal.TEN, this.CURRENCY);
        Wallet founded = new Wallet(1, BigDecimal.TEN);

        Mockito
                .when(this.providerManager.getCurrencyProvider())
                .thenReturn(this.currencyProvider);
        Mockito
                .when(this.providerManager.getThirdPartyProvider())
                .thenReturn(this.thirdPartyProvider);
        Mockito
                .when(this.providerManager.getWalletEntityManager())
                .thenReturn(this.walletManager);
        Mockito
                .when(this.providerManager.getTransferEntityManager())
                .thenReturn(this.transferManager);
        Mockito
                .when(this.currencyProvider.change(Mockito.any(), Mockito.any(), Mockito.any()))
                .thenReturn(BigDecimal.TEN);
        Mockito
                .when(this.walletManager.find(Mockito.anyLong()))
                .thenReturn(founded);
    }

    @Test
    public void success_load() {
        Wallet expected = new Wallet(1, BigDecimal.valueOf(20));

        Wallet result = this.service.load(this.request);

        Mockito.verify(this.walletManager, Mockito.times(1)).find(1L);
        Mockito.verify(this.walletManager, Mockito.times(1)).update(Mockito.any());
        Mockito.verify(this.transferManager, Mockito.times(1)).insert(Mockito.anyLong(), Mockito.any());
        Assert.assertEquals(expected, result);
    }

    @Test(expected = WalletNotFoundException.class)
    public void error_no_exist_wallet() {
        Mockito
                .when(this.walletManager.find(Mockito.anyLong()))
                .thenThrow(new WalletNotFoundException(1L));

        this.service.load(this.request);
    }

    @Test(expected = NegativeAmountException.class)
    public void error_negative_amount() {
        this.service.load(new LoadWalletRequest(1, BigDecimal.valueOf(-15), this.CURRENCY));
    }

    @Test(expected = CurrencyNotFoundException.class)
    public void error_currency_not_found() {
        Mockito
                .when(this.currencyProvider.change(Mockito.any(), Mockito.any(), Mockito.any()))
                .thenThrow(new CurrencyNotFoundException(this.CURRENCY));

        this.service.load(this.request);
    }

    @Test(expected = ThirdPartyNotAvailable.class)
    public void error_third_party_platform() {
        Mockito.doThrow(new ThirdPartyNotAvailable())
                .when(this.thirdPartyProvider).charge(Mockito.any(), Mockito.anyString(), Mockito.any());

        this.service.load(this.request);
    }

}
