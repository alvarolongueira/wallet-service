package com.playtomic.tests.wallet.api.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SpendWalletRequest {

    private long walletId;

    private BigDecimal amount;

}
