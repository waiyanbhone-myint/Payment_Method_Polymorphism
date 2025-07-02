package com.ps;

public class BankTransfer extends  Payment{
    private String accountNumber;
    private String routingNumber;

    public BankTransfer(String paymentId, double amount, String customerName,
                        String accountNumber, String routingNumber) {
        super(paymentId, amount, customerName);
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
    }

    @Override
    public boolean processPayment() {
        if(accountNumber.length() != 10 && routingNumber.length() != 9){
            System.out.println("Please enter valid account number or routing number!");
            return false;
        };

        System.out.println("Contacting to your Bank");
        System.out.println("Bank Transfer Payment Processing");
        System.out.println("Bank Transfer Authorized");
        return true;
    }

    @Override
    public double calculateProcessingFee() {
        return getAmount()+ 1.5;
    }

    @Override
    public String getPaymentMethod() {
        return "Bank Transfer";
    }
}
