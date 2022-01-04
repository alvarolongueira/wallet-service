package com.playtomic.tests.wallet.api.request;

import java.math.BigDecimal;
import java.util.Currency;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoadWalletRequest {

    private long walletId;

    private BigDecimal amount;

    private Currency currency;

}
