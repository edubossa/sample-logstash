package br.com.gateway.domain;

import java.util.UUID;

/**
 * Created by wallace on 07/03/17.
 */
public class Card {

    private String number;
    private String expirationMonth;
    private String expirationYear;
    private String cvv;
    private String brand;
    private String holderName;

    public Card() {
    }

    public Card(String number, String expirationMonth, String expirationYear, String cvv, String brand, String holderName) {
        this.number = number;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.cvv = cvv;
        this.brand = brand;
        this.holderName = holderName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public static Card create() {
        Card card = new Card();
        card.setBrand("VISA");
        card.setCvv("343");
        card.setExpirationMonth("06");
        card.setExpirationYear("2020");
        card.setHolderName("TEST CREDIT CARD");
        card.setNumber(UUID.randomUUID().toString());
        return card;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number='" + number + '\'' +
                ", expirationMonth='" + expirationMonth + '\'' +
                ", expirationYear='" + expirationYear + '\'' +
                ", cvv='" + cvv + '\'' +
                ", brand='" + brand + '\'' +
                ", holderName='" + holderName + '\'' +
                '}';
    }

}
