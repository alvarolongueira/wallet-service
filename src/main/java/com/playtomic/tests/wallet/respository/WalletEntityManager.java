package com.playtomic.tests.wallet.respository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.playtomic.tests.wallet.domain.Wallet;
import com.playtomic.tests.wallet.exception.domain.WalletNotFoundException;
import com.playtomic.tests.wallet.respository.database.WalletRepository;
import com.playtomic.tests.wallet.respository.entity.WalletEntity;

@Service
public class WalletEntityManager {

    private final WalletRepository repository;

    public WalletEntityManager(WalletRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Wallet find(long walletId) throws WalletNotFoundException {
        return this.repository.findById(walletId).map(this::convertToDomain).orElseThrow(() -> new WalletNotFoundException(walletId));
    }

    @Transactional
    public void create(Wallet wallet) {
        //TODO
    }

    @Transactional
    public void update(Wallet wallet) {
        //TODO
    }

    private Wallet convertToDomain(WalletEntity entity) {
        return new Wallet(entity.getId(), entity.getAmount());
    }
}
