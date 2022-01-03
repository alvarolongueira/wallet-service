package com.playtomic.tests.wallet.respository;

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
        return null;    //TODO
    }

    @Transactional
    public Set<Transfer> findTransfers(long walletId) {
        return null;    //TODO
    }

    @Transactional
    public void insert(long walletId, long amount) {
        //TODO
    }

}
