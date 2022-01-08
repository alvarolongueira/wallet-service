package com.playtomic.tests.wallet.repository;

import java.math.BigDecimal;
import java.util.Set;

import com.playtomic.tests.wallet.domain.Transfer;

public interface TransferEntityManager {

    public Transfer findById(long transferId);

    public Set<Transfer> findTransfers(long walletId);

    public void insert(long walletId, BigDecimal amount);

}
