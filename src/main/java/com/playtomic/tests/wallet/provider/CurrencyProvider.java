package com.playtomic.tests.wallet.provider;

import java.math.BigDecimal;
import java.util.Currency;

public interface CurrencyProvider {

    BigDecimal change(BigDecimal amount, Currency source, Currency target);

}
