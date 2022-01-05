package com.playtomic.tests.wallet.respository.database;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.playtomic.tests.wallet.domain.Transfer;
import com.playtomic.tests.wallet.respository.TransferEntityManager;

@Service
public class TransferEntityManagerImpl implements TransferEntityManager {

    private final TransferRepository repository;

    public TransferEntityManagerImpl(TransferRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Transfer findById(long transferId) {
        //TODO implementation not required for this test
        return null;
    }

    @Override
    @Transactional
    public Set<Transfer> findTransfers(long walletId) {
        //TODO implementation not required for this test
        return null;
    }

    @Override
    @Transactional
    public void insert(long walletId, BigDecimal amount) {
        //TODO implementation not required for this test
    }

}
