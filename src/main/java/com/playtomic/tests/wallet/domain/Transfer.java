package com.playtomic.tests.wallet.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transfer {

    private long id;

    private long walletId;

    private BigDecimal amount;

    @Builder.Default
    private boolean returned = false;

}
