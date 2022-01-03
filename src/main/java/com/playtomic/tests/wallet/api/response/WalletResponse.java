package com.playtomic.tests.wallet.api.response;

import com.playtomic.tests.wallet.domain.Wallet;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WalletResponse {

    private long id;

    private long amount;

    public static WalletResponse convertToResponse(Wallet wallet) {
        return new WalletResponse(wallet.getId(), wallet.getAmount());
    }
}
