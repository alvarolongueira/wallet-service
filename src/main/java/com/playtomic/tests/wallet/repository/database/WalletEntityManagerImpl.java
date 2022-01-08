package com.playtomic.tests.wallet.repository.database;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.playtomic.tests.wallet.domain.Wallet;
import com.playtomic.tests.wallet.exception.domain.NegativeAmountException;
import com.playtomic.tests.wallet.exception.domain.WalletNotFoundException;
import com.playtomic.tests.wallet.repository.WalletEntityManager;
import com.playtomic.tests.wallet.repository.entity.WalletEntity;

@Service
public class WalletEntityManagerImpl implements WalletEntityManager {

    private final WalletEntityRepository repository;

    public WalletEntityManagerImpl(WalletEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Wallet find(long walletId) throws WalletNotFoundException {
        return this.repository.findById(walletId).map(this::convertToDomain).orElseThrow(() -> new WalletNotFoundException(walletId));
    }

    @Override
    @Transactional
    public Wallet create() {
        WalletEntity entity = this.repository.save(new WalletEntity().withAmount(BigDecimal.ZERO));
        return this.convertToDomain(entity);
    }

    @Override
    @Transactional
    public void update(Wallet wallet) {
        if (BigDecimal.ZERO.compareTo(wallet.getAmount()) > 0) {
            throw new NegativeAmountException(wallet.getAmount());
        }
        WalletEntity entity = this.repository.findById(wallet.getId()).orElseThrow(() -> new WalletNotFoundException(wallet.getId()));
        entity = entity.withAmount(wallet.getAmount());
        this.repository.save(entity);
    }

    private Wallet convertToDomain(WalletEntity entity) {
        return new Wallet(entity.getId(), entity.getAmount());
    }
}
