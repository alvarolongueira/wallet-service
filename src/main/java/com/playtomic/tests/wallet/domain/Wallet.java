package com.playtomic.tests.wallet.domain;

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
    private long amount;

}
