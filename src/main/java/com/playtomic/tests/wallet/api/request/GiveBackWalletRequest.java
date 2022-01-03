package com.playtomic.tests.wallet.api.request;

import lombok.Data;

@Data
public class GiveBackWalletRequest {

    private long walletId;

    private long transferId;

}
