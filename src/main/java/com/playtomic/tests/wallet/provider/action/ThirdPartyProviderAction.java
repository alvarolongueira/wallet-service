package com.playtomic.tests.wallet.provider.action;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playtomic.tests.wallet.domain.ThirdParty;
import com.playtomic.tests.wallet.provider.ThirdPartyProvider;
import com.playtomic.tests.wallet.service.StripeService;

@Service
public class ThirdPartyProviderAction implements ThirdPartyProvider {

    @Autowired
    private final
    StripeService stripeService;

    public ThirdPartyProviderAction(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @Override
    public void charge(ThirdParty thirdParty, String creditCardNumber, BigDecimal amount) {
        switch (thirdParty) {
            case STRIPE:
                this.stripeService.charge(creditCardNumber, amount);
                break;
            default:
                throw new UnsupportedOperationException("Third party unsupported " + thirdParty);
        }
    }

    @Override
    public void refund(ThirdParty thirdParty, String paymentId) {
        switch (thirdParty) {
            case STRIPE:
                this.stripeService.refund(paymentId);
                break;
            default:
                throw new UnsupportedOperationException("Third party unsupported " + thirdParty);
        }
    }
}
