package br.com.gateway.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

/**
 * Created by wallace on 13/03/17.
 */
public class Transaction {

    private String orderId;
    private String transactionId;
    private Collection<Payment> payments;

    public Transaction() {
        this.transactionId = UUID.randomUUID().toString();
        this.orderId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public Transaction(Collection<Payment> payments) {
        this.payments = payments;
        this.transactionId = UUID.randomUUID().toString();
        this.orderId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public Transaction(String orderId, String transactionId, Collection<Payment> payments) {
        this.orderId = orderId;
        this.transactionId = transactionId;
        this.payments = payments;
    }

    public Collection<Payment> getPayments() {
        if (payments == null) {
            this.payments = new ArrayList<>();
        }
        return payments;
    }

    public void setPayments(Collection<Payment> payments) {
        this.payments = payments;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "orderId='" + orderId + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", payments=" + payments +
                '}';
    }

}
