package com.playtomic.tests.wallet.service.impl;


import java.math.BigDecimal;
import java.net.URI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;

import com.playtomic.tests.wallet.service.StripeAmountTooSmallException;
import com.playtomic.tests.wallet.service.StripeService;
import com.playtomic.tests.wallet.service.StripeServiceException;

/**
 * This test is failing with the current implementation.
 *
 * How would you test this?
 */
public class StripeServiceTest {

    private URI testUri = URI.create("http://how-would-you-test-me.localhost");
    private StripeService s = new StripeService(this.testUri, this.testUri, new RestTemplateBuilder());

    @Test
    public void test_exception() {
        Assertions.assertThrows(StripeAmountTooSmallException.class, () -> {
            this.s.charge("4242 4242 4242 4242", new BigDecimal(5));
        });
    }

    @Test
    public void test_ok() throws StripeServiceException {
        this.s.charge("4242 4242 4242 4242", new BigDecimal(15));
    }
}
