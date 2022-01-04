package com.playtomic.tests.wallet.api.response;

import java.math.BigDecimal;

import com.playtomic.tests.wallet.domain.Wallet;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WalletResponse {

    private long id;

    private BigDecimal amount;

    public static WalletResponse convertToResponse(Wallet wallet) {
        return new WalletResponse(wallet.getId(), wallet.getAmount());
    }
}
