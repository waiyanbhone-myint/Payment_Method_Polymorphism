package com.ps.model;

import com.ps.model.enums.PaymentMethodType;
import com.ps.model.enums.PaymentStatus;

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

        System.out.println(PaymentStatus.PENDING);
        System.out.println(PaymentStatus.PROCESSING);
        System.out.println(PaymentStatus.AUTHORIZED);
        return true;
    }

    @Override
    public double calculateProcessingFee() {
        return getAmount()+ 1.5;
    }

    @Override
    public PaymentMethodType getPaymentMethod() {
        return PaymentMethodType.BANK_TRANSFER;
    }
}
