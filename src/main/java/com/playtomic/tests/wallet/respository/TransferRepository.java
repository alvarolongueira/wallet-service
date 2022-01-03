package com.playtomic.tests.wallet.respository;

import java.util.Set;

import com.playtomic.tests.wallet.domain.Transfer;

public interface TransferRepository {

    Transfer findById(long transferId);

    Set<Transfer> findTransfers(long walletId);

    void insert(long walletId, long amount);

}
