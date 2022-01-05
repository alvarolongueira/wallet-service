package com.playtomic.tests.wallet.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.playtomic.tests.wallet.domain.Wallet;
import com.playtomic.tests.wallet.exception.domain.WalletNotFoundException;
import com.playtomic.tests.wallet.respository.WalletEntityManager;
import com.playtomic.tests.wallet.respository.database.WalletEntityManagerImpl;
import com.playtomic.tests.wallet.respository.database.WalletEntityRepository;
import com.playtomic.tests.wallet.respository.entity.WalletEntity;

@RunWith(MockitoJUnitRunner.class)
public class WalletEntityManagerTest {

    @Mock
    private WalletEntityRepository repository;

    private WalletEntityManager manager;

    @Before
    public void init() {
        this.manager = new WalletEntityManagerImpl(this.repository);
    }

    @Test
    public void success() {
        WalletEntity entity = new WalletEntity(1, BigDecimal.TEN);
        Wallet expected = new Wallet(1, BigDecimal.TEN);
        Mockito.when(this.repository.findById(Mockito.anyLong())).thenReturn(Optional.of(entity));

        Wallet result = this.manager.find(1);

        Mockito.verify(this.repository).findById(1L);
        Assert.assertEquals(expected, result);
    }

    @Test(expected = WalletNotFoundException.class)
    public void not_found() {
        this.manager.find(1);
    }

    //TODO test more things

}
