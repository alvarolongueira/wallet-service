package com.playtomic.tests.wallet.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class WalletController {
    private final Logger log = LoggerFactory.getLogger(WalletController.class);

    @RequestMapping("/")
    void log() {
        this.log.info("Logging from /");
    }



//    - Puedes consultar el saldo.
//            - Puedes cargar dinero. En este caso haciendo un cobro una pasarela pasarela de pagos de terceros (stripe, paypal, redsys).
//            - Puedes gastar el saldo en compras en nuestra plataforma.
//- Puedes devolver esas compras y recuperar el saldo.
//            - Puedes consultar el histórico de gastos y devoluciones.
}
