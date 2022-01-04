package com.playtomic.tests.wallet.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.With;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Wallet {

    private long id;

    @With
    private BigDecimal amount;

}
