package com.playtomic.tests.wallet.repository.database;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.playtomic.tests.wallet.domain.Transfer;
import com.playtomic.tests.wallet.repository.TransferEntityManager;

@Service
public class TransferEntityManagerImpl implements TransferEntityManager {

    private final TransferEntityRepository repository;

    public TransferEntityManagerImpl(TransferEntityRepository repository) {
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
