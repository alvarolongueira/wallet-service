package com.playtomic.tests.wallet.service.impl;


import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.playtomic.tests.wallet.service.StripeAmountTooSmallException;
import com.playtomic.tests.wallet.service.StripeService;
import com.playtomic.tests.wallet.service.StripeServiceException;

/**
 * This test is failing with the current implementation.
 * <p>
 * How would you test this?
 */
@RunWith(MockitoJUnitRunner.class)
public class StripeServiceTest {

    @Mock
    private StripeService service;

    @Before
    public void init() {
        Mockito.doNothing().when(this.service).charge(Mockito.any(), Mockito.any());
        Mockito.doThrow(new StripeAmountTooSmallException()).when(this.service).charge(Mockito.any(), Mockito.argThat(this.biggerThanTen()));
    }

    private ArgumentMatcher<BigDecimal> biggerThanTen() {
        return new ArgumentMatcher<BigDecimal>() {
            @Override
            public boolean matches(BigDecimal argument) {
                return BigDecimal.TEN.compareTo(argument) > 0;
            }
        };
    }

    @Test
    public void test_exception() {
        Assertions.assertThrows(StripeAmountTooSmallException.class, () -> {
            this.service.charge("4242 4242 4242 4242", new BigDecimal(5));
        });
    }

    @Test
    public void test_ok() throws StripeServiceException {
        this.service.charge("4242 4242 4242 4242", new BigDecimal(15));
    }
}
