package com.ps.model;

public abstract class Payment {

    private String paymentId;
    private double amount;
    private String customerName;

    public Payment(String paymentId, double amount, String customerName) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.customerName = customerName;
    }

    public abstract boolean processPayment();
    public abstract double calculateProcessingFee();
    public abstract String getPaymentMethod();

    public void displayPaymentInfo(){
        System.out.println("=====Payment Information=====");
        System.out.println("Payment Id: " + paymentId);
        System.out.println("Payment Amount: " + amount);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Payment Type: " + getPaymentMethod());
    }

    public double getFinalAmount(){
        return amount + calculateProcessingFee();
    }

    public String getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public String getCustomerName() {
        return customerName;
    }
}
