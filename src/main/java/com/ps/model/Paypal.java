package com.ps.model;

public class Paypal extends Payment {

    private String email;
    private String paypalId;
    private String accountType;
    private boolean isVerified;

    public Paypal(String paymentId, double amount, String customerName, String email,
                  String paypalId, String accountType, boolean isVerified) {
        super(paymentId, amount, customerName);
        this.email = email;
        this.paypalId = paypalId;
        this.accountType = accountType;
        this.isVerified = isVerified;
    }

    public Paypal(String paymentId, double amount, String customerName, String email,
                  String paypalId, String accountType) {
        super(paymentId, amount, customerName);
        this.email = email;
        this.paypalId = paypalId;
        this.accountType = accountType;
    }

    @Override
    public boolean processPayment() {
        if(!email.contains("@")){
            System.out.println("Please use valid email address.");
            return false;
        }

        if(getAmount()>500 && isVerified == false){
            System.out.println("Please verify account to transfer over $500");
            return false;
        }

        System.out.println("Contacting Paypal...");
        System.out.println("Paypal email " + email);
        System.out.println("Paypal payment authorized.");
        return true;
    }

    @Override
    public double calculateProcessingFee() {
        return getAmount() * 0.034;
    }

    @Override
    public String getPaymentMethod() {
        return "Paypal";
    }
}
