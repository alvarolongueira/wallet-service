package com.playtomic.tests.wallet.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoadWalletRequest {

    private long walletId;

    private long amount;

}
