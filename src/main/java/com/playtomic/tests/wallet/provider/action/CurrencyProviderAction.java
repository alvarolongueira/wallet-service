package com.playtomic.tests.wallet.provider.action;

import java.math.BigDecimal;
import java.util.Currency;

import org.springframework.stereotype.Service;

import com.playtomic.tests.wallet.provider.CurrencyProvider;

@Service
public class CurrencyProviderAction implements CurrencyProvider {

    @Override
    public BigDecimal change(BigDecimal amount, Currency source, Currency target) {
        //TODO query external service
        return amount;
    }

}
