package com.playtomic.tests.wallet.respository;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.playtomic.tests.wallet.domain.Transfer;
import com.playtomic.tests.wallet.respository.database.TransferRepository;

@Service
public class TransferEntityManager {

    private final TransferRepository repository;

    public TransferEntityManager(TransferRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Transfer findById(long transferId) {
        //TODO implementation not required for this test
        return null;
    }

    @Transactional
    public Set<Transfer> findTransfers(long walletId) {
        //TODO implementation not required for this test
        return null;
    }

    @Transactional
    public void insert(long walletId, BigDecimal amount) {
        //TODO implementation not required for this test
    }

}
