package com.playtomic.tests.wallet.api.request;

import lombok.Data;

@Data
public class SpendWalletRequest {

    private long walletId;

    private long amount;

}
