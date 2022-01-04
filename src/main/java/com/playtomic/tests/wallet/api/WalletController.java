package com.playtomic.tests.wallet.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playtomic.tests.wallet.api.request.GiveBackWalletRequest;
import com.playtomic.tests.wallet.api.request.LoadWalletRequest;
import com.playtomic.tests.wallet.api.request.SpendWalletRequest;
import com.playtomic.tests.wallet.api.response.ResponseBody;
import com.playtomic.tests.wallet.api.response.WalletResponse;
import com.playtomic.tests.wallet.business.CreateWalletService;
import com.playtomic.tests.wallet.business.FindAllTransferService;
import com.playtomic.tests.wallet.business.FindWalletService;
import com.playtomic.tests.wallet.business.GiveBackTransferService;
import com.playtomic.tests.wallet.business.LoadWalletService;
import com.playtomic.tests.wallet.business.SpendWalletService;
import com.playtomic.tests.wallet.domain.Wallet;

@RestController
class WalletController {

    private final Logger log = LoggerFactory.getLogger(WalletController.class);

    @Autowired
    private FindWalletService findWalletService;

    @Autowired
    private FindAllTransferService findAllTransferService;

    @Autowired
    private CreateWalletService createWalletService;

    @Autowired
    private LoadWalletService loadWalletService;

    @Autowired
    private SpendWalletService spendWalletService;

    @Autowired
    private GiveBackTransferService giveBackTransferService;

    @RequestMapping("/")
    void log() {
        this.log.info("Logging from /");
    }

    @GetMapping(path = "/get/{walletId}")
    public ResponseEntity<WalletResponse> findWallet(@PathVariable(name = "walletId") long walletId) {
        Wallet wallet = this.findWalletService.find(walletId);
        WalletResponse response = WalletResponse.convertToResponse(wallet);
        return ResponseBody.of(response);
    }

    @GetMapping(path = "/all/{walletId}")
    public ResponseEntity<WalletResponse> findAllTransfer(@PathVariable(name = "walletId") long walletId) {
        Wallet wallet = this.findAllTransferService.find(walletId);
        WalletResponse response = WalletResponse.convertToResponse(wallet);
        return ResponseBody.of(response);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<WalletResponse> createWallet() {
        Wallet wallet = this.createWalletService.create();
        WalletResponse response = WalletResponse.convertToResponse(wallet);
        return ResponseBody.of(response);
    }

    @PostMapping(path = "/load")
    public ResponseEntity<WalletResponse> loadWallet(@RequestBody LoadWalletRequest request) {
        Wallet wallet = this.loadWalletService.load(request);
        WalletResponse response = WalletResponse.convertToResponse(wallet);
        return ResponseBody.of(response);
    }

    @PostMapping(path = "/spend")
    public ResponseEntity<WalletResponse> spendWallet(@RequestBody SpendWalletRequest request) {
        Wallet wallet = this.spendWalletService.spend(request);
        WalletResponse response = WalletResponse.convertToResponse(wallet);
        return ResponseBody.of(response);
    }

    @PostMapping(path = "/giveback")
    public ResponseEntity<WalletResponse> giveBackTransfer(@RequestBody GiveBackWalletRequest request) {
        Wallet wallet = this.giveBackTransferService.giveBack(request);
        WalletResponse response = WalletResponse.convertToResponse(wallet);
        return ResponseBody.of(response);
    }

}
