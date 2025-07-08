package com.ps.model.enums;

public enum PaymentMethodType {
    CREDIT_CARD("Credit Card"),
    PAYPAL("PayPal"),
    BANK_TRANSFER("Bank Transfer"),
    CASH("Cash");

    private final String displayName;

    PaymentMethodType(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}
