package com.playtomic.tests.wallet.provider;

import java.math.BigDecimal;

import com.playtomic.tests.wallet.domain.ThirdParty;

public interface ThirdPartyProvider {

    void charge(ThirdParty thirdParty, String creditCardNumber, BigDecimal amount);

    void refund(ThirdParty thirdParty, String paymentId);

}
