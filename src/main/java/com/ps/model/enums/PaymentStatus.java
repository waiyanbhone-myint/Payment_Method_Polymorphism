package com.ps.model.enums;

public enum PaymentStatus {
    PENDING("Payment Pending"),
    PROCESSING("Payment Processing"),
    AUTHORIZED("Payment Authorized"),
    COMPLETED("Payment Completed"),
    FAILED("Payment Failed"),
    CANCELLED("Payment Cancelled");

    private final String description;

    PaymentStatus(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
