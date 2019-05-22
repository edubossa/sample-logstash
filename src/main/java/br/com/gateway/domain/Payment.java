package br.com.gateway.domain;

/**
 * Created by wallace on 07/03/17.
 */
public class Payment {

    private String description;
    private String amount;
    private Card card;

    public Payment() {
    }

    public Payment(String description, String amount, Card card) {
        this.description = description;
        this.amount = amount;
        this.card = card;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "description='" + description + '\'' +
                ", amount=" + amount +
                ", card=" + card +
                '}';
    }
}
