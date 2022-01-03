package com.playtomic.tests.wallet.provider;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.playtomic.tests.wallet.domain.ThirdParty;
import com.playtomic.tests.wallet.service.StripeService;

public class ThirdPartyProviderAction implements ThirdPartyProvider {

    @Autowired
    private final
    StripeService stripeService;

    public ThirdPartyProviderAction(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @Bean
    @Override
    public void charge(ThirdParty thirdParty, String creditCardNumber, BigDecimal amount) {
        switch (thirdParty) {
            case STRIPE:
                this.stripeService.charge(creditCardNumber, amount);
            default:
                throw new UnsupportedOperationException("Third party unsupported " + thirdParty);
        }
    }

    @Bean
    @Override
    public void refund(ThirdParty thirdParty, String paymentId) {
        switch (thirdParty) {
            case STRIPE:
                this.stripeService.refund(paymentId);
            default:
                throw new UnsupportedOperationException("Third party unsupported " + thirdParty);
        }
    }
}
