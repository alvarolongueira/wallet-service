package com.playtomic.tests.wallet.api;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.playtomic.tests.wallet.api.request.LoadWalletRequest;
import com.playtomic.tests.wallet.api.response.WalletResponse;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

@ActiveProfiles(profiles = "test")
public class WalletControllerTest {

    @Autowired
    private WalletController controller;

    @Autowired
    private TestRestTemplate template;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Currency CURRENCY = Currency.getInstance(Locale.getDefault());

    @Test
    public void creation_wallet_and_load_success() throws Exception {

        //check context
        Assert.assertNotNull(this.controller);
        ResponseEntity<String> responseEntity = this.template.getForEntity("/", String.class);
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        final long id = 1L;

        //create wallet
        responseEntity = this.template.postForEntity("/create", null, String.class);
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        WalletResponse wallet = this.objectMapper.readValue(responseEntity.getBody(), WalletResponse.class);
        Assert.assertEquals(id, wallet.getId());
        Assert.assertEquals(BigDecimal.ZERO, wallet.getAmount());

        //find wallet
        responseEntity = this.template.getForEntity("/get/" + id, String.class);
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        wallet = this.objectMapper.readValue(responseEntity.getBody(), WalletResponse.class);
        Assert.assertEquals(id, wallet.getId());
        Assert.assertTrue(BigDecimal.ZERO.compareTo(wallet.getAmount()) == 0);

        //load wallet
        LoadWalletRequest loadWalletRequest = new LoadWalletRequest(id, BigDecimal.TEN, this.CURRENCY);
        responseEntity = this.template.postForEntity("/load", loadWalletRequest, String.class);
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        wallet = this.objectMapper.readValue(responseEntity.getBody(), WalletResponse.class);
        Assert.assertEquals(id, wallet.getId());
        Assert.assertTrue(BigDecimal.TEN.compareTo(wallet.getAmount()) == 0);

        //find wallet loaded
        responseEntity = this.template.getForEntity("/get/" + id, String.class);
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        wallet = this.objectMapper.readValue(responseEntity.getBody(), WalletResponse.class);
        Assert.assertEquals(id, wallet.getId());
        Assert.assertTrue(BigDecimal.TEN.compareTo(wallet.getAmount()) == 0);

    }

}
