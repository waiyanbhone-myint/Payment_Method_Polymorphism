package com.ps.model;

import com.ps.model.enums.PaymentMethodType;

public class Cash extends Payment{

    private String cashierId;
    private String registerNumber;
    private double amountReceived;
    private double changeGiven;
    private String receiptNumber;

    public Cash(String paymentId, double amount, String customerName,
                String cashierId, String registerNumber, double amountReceived) {
        super(paymentId, amount, customerName);
        this.cashierId = cashierId;
        this.registerNumber = registerNumber;
        this.amountReceived = amountReceived;
        this.changeGiven = amountReceived > amount? amountReceived - amount:amountReceived;
        this.receiptNumber = "RE " + paymentId;
    }

    @Override
    public boolean processPayment() {
        System.out.println("Processing Payment...");
        if(amountReceived < getAmount()){
            System.out.println("Insufficient Balance");
        }
        System.out.println("Cashier Id: " + cashierId);
        System.out.println("Register: " + registerNumber);
        System.out.println("Amount Due: " + getAmount());
        System.out.println("Cash Received: " + amountReceived);
        System.out.println("Change Given: " + changeGiven);
        System.out.println("Receipt #:" + receiptNumber);
        System.out.println("Cash payment completed");
        return true;

    }

    @Override
    public double calculateProcessingFee() {
        return getAmount();
    }

    @Override
    public PaymentMethodType getPaymentMethod() {
        return PaymentMethodType.CASH;
    }

    public String getCashierId() {
        return cashierId;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public double getAmountReceived() {
        return amountReceived;
    }

    public double getChangeGiven() {
        return changeGiven;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }
}
