package com.playtomic.tests.wallet.provider;

import java.math.BigDecimal;

import com.playtomic.tests.wallet.domain.ThirdParty;

public interface ThirdPartyProvider {

    public void charge(ThirdParty thirdParty, String creditCardNumber, BigDecimal amount);

    public void refund(ThirdParty thirdParty, String paymentId);

}
