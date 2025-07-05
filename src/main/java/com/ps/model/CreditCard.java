package com.ps.model;

public class CreditCard extends Payment{
    private String cardNumber;
    private String expirationDate;

    public CreditCard(String paymentId, double amount, String customerName,
                      String cardNumber, String expirationDate){
        super(paymentId, amount, customerName);
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean processPayment() {
        System.out.println("Processing credit card payment...");

        if(cardNumber.length() != 16){
            System.out.println("Please enter valid card number.");
            return false;
        }

        System.out.println("Contacting credit card company....");
        System.out.println("Card ending in ****" + cardNumber.substring(12));
        System.out.println("Credit Card payment authorized.");
        return true;
    }

    @Override
    public double calculateProcessingFee() {
        return getAmount() * 0.029;
    }

    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }
}
