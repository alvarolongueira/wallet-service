package com.playtomic.tests.wallet.business.action;

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
import com.playtomic.tests.wallet.respository.TransferEntityManager;
import com.playtomic.tests.wallet.respository.WalletEntityManager;

@RunWith(MockitoJUnitRunner.class)
public class LoadWalletServiceActionTest {

    @Mock
    private WalletEntityManager walletManager;

    @Mock
    private TransferEntityManager transferManager;

    private LoadWalletService service;

    private LoadWalletRequest request;

    @Before
    public void init() {
        this.service = new LoadWalletServiceAction(this.walletManager, this.transferManager);
        this.request = new LoadWalletRequest(1, 15);
    }

    @Test
    public void success_load() {
        Wallet expected = new Wallet(1, 5);
        Mockito.when(this.walletManager.find(Mockito.anyLong())).thenReturn(expected);

        Wallet result = this.service.load(this.request);

        Mockito.verify(this.walletManager, Mockito.times(2)).find(1L);
        Mockito.verify(this.walletManager, Mockito.times(1)).update(Mockito.any());
        Mockito.verify(this.transferManager, Mockito.times(1)).insert(Mockito.anyLong(), Mockito.anyLong());
        Assert.assertEquals(expected, result);
    }

    @Test(expected = WalletNotFoundException.class)
    public void error_no_exist_wallet() {
        Mockito.when(this.walletManager.find(Mockito.anyLong())).thenThrow(new WalletNotFoundException(1L));
        Wallet result = this.service.load(this.request);
    }

    @Test(expected = NegativeAmountException.class)
    public void error_negative_amount() {

    }

    @Test(expected = CurrencyNotFoundException.class)
    public void error_currency_not_found() {

    }

    @Test(expected = ThirdPartyNotAvailable.class)
    public void error_third_party_platform() {

    }

}
