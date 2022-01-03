package com.playtomic.tests.wallet.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transfer {

    private long id;

    private long walletId;

    private long amount;

    @Builder.Default
    private boolean returned = false;

}
