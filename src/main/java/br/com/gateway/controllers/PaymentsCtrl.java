package br.com.gateway.controllers;

import br.com.gateway.domain.Card;
import br.com.gateway.domain.Payment;
import br.com.gateway.domain.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by wallace on 07/03/17.
 *
     * http://localhost:8080/payments
 */
@RestController
@RequestMapping("/payments")
public class PaymentsCtrl {

    private static final Logger log = LoggerFactory.getLogger(PaymentsCtrl.class);


    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<Transaction> payments() {
        Transaction transaction = new Transaction();
        MDC.put("transactionId", transaction.getTransactionId());
        MDC.put("orderId", transaction.getOrderId());
        log.info("PaymentsCtrl.payments");
        transaction.getPayments().add(new Payment("MONITOR", "1234.89", Card.create()));
        transaction.getPayments().add(new Payment("DVD", "234.00", Card.create()));
        transaction.getPayments().add(new Payment("CD", "23.98", Card.create()));
        transaction.getPayments().add(new Payment("MOUSE", "43.78", Card.create()));
        transaction.getPayments().add(new Payment("KEYBOARD", "45.87", Card.create()));
        transaction.getPayments().add(new Payment("CELL PHONE", "90.69", Card.create()));
        transaction.getPayments().add(new Payment("PENCIL", "1.59", Card.create()));
        transaction.getPayments().add(new Payment("DESK", "345.87", Card.create()));
        transaction.getPayments().add(new Payment("CHAIR", "134.84", Card.create()));
        transaction.getPayments().add(new Payment("COFFEE MACHINE", "12.39", Card.create()));
        transaction.getPayments().add(new Payment("TABLE", "924.23", Card.create()));
        log.info(transaction.toString());
        return ResponseEntity.ok(transaction);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Transaction> addPay() {
        Transaction transaction = new Transaction();
        MDC.put("transactionId", transaction.getTransactionId());
        MDC.put("orderId", transaction.getOrderId());
        log.info("PaymentsCtrl.directPay");
        log.warn("TransactionId -> " + transaction.getTransactionId());
        log.warn("OrderId -> " + transaction.getOrderId());
        transaction.getPayments().add(new Payment("Monitor", "534.90", Card.create()));
        log.info(transaction.toString());
        return ResponseEntity.ok(transaction);
    }

    @RequestMapping(value = "/log/{count}", method = RequestMethod.GET)
    int logCount(@PathVariable("count") int count) {
        Transaction transaction = new Transaction();
        MDC.put("transactionId", transaction.getTransactionId());
        MDC.put("orderId", transaction.getOrderId());
        log.info("PaymentsCtrl.logCount --> " + count);
        for(int i = 0; i <= count; i++) {
            transaction.getPayments().add(new Payment(UUID.randomUUID().toString(), "1234.89", Card.create()));
            log.info(transaction.toString());
        }
        return count;
    }

}
